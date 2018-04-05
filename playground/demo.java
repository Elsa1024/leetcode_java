   public Result retrieveAssignedBusinessAccountTagAllBusinessAccountList() {
        String userId = session().get("userId");
        BusinessAccountTagRequest request = Util.fromJsonObject(request().body().asJson(), BusinessAccountTagRequest.class);
        RequestResult ret = new RequestResult((String) ctx().args.get("ROUTE_PATTERN"), request().body().asJson().toString());
        int errorCode = ErrorCode.OPERATION_FAIL;
        if (request != null) {
            try  {
                if (CollectionUtils.isEmpty(request.getBusinessAccountTags())) {
                    PersonInfoDataObject userCheck = userDao.getUser(userId, "id");
                    JsonNode jsonNode = request().body().asJson();
                    boolean includeTerminatedUsers = jsonNode.get("includeTerminatedUsers") != null && jsonNode.get("includeTerminatedUsers").asBoolean();
                    Util.constructBusinessAccountListHelper(userDao, userCheck, null, userId, ret,  false, true, false, includeTerminatedUsers, true);
                } else {
                    List<BusinessAccountDataObject> businessAccountList = userDao.retrieveBusinessAccountTagList(request.getBusinessAccountTags());
                    ret.setResult(Util.toJsonObject(businessAccountList));
                }
                errorCode = ErrorCode.OPERATION_SUCCESS;
            } catch (Exception e) {
                logger.error("Failed to retrieve business account tag business account list", e);
                ret.setResult(e.getMessage());
            }
        }
        ret.setErrorCode(errorCode);
        return ok(ret.getResult());
    }