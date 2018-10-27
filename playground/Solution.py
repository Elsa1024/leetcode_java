import collections
import re
import numpy

from urllib.request import urlopen

def write_chunks_of_five(words,fname):
    '''
    :param: words
    :type: list
    :param: fname
    :type: str
    '''
    # YOUR CODE HERE
    assert type(words) == list
    for word in words:
        assert type(word) == str
    f = open(fname, 'w')
    for i in range(0, len(words), 5):
        for j in range(i, i+5):
            if j < len(words):
              f.write(words[j])
              if j < i+4:
                f.write(' ')
              elif i != len(words)-1:
                f.write('\n')
    f.close()


u='https://storage.googleapis.com/class-notes-181217.appspot.com/google-10000-english-no-swears.txt'
response = urlopen(u)
words = [i.strip().decode('utf8') for i in response.readlines()]

write_chunks_of_five(words, 'test_final.txt')