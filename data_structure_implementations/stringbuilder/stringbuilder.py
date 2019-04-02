# Author: Eric Lai
from typing import List
import time

class StringBuilder():
    def __init__(self):
        self.__string_list: List[str] = []

    def __str__(self):
        if self.__string_list == []:
            return ''
        else:
            return ''.join(self.__string_list)

    def add(self, s: str) -> None:
        self.__string_list += [s]


if __name__ == '__main__':

    stime = time.time()
    s = StringBuilder()
    for _ in range(3000000):
        s.add("eeee")
    etime = time.time() - stime
    print(etime)

    stime = time.time()
    s = ''
    for _ in range(3000000):
        s += 'eeee'
    etime = time.time() - stime
    print(etime)



