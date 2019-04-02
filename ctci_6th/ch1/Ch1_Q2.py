'''
Mistakes:
- Switching variable names accidentally = 2
'''

def isPerm(n, m):

    if len(n) != len(m):
        return False
    elif (n == m):
        return True
    else:
        dict = {}

        for char in n:
            if dict.get(char, None) == None:
                dict[char] = 1
            else:
                dict[char] += 1
        
        for char in m:
            if dict.get(char, None) == None:
                return False
            elif (dict[char] -1 < 0):
                return False
            else:
                dict[char] -= 1

        for val in dict.values():
            if val > 0:
                return False
        
        return True

if __name__ == "__main__":
    print(isPerm("","asdfasdg"))            # false
    print(isPerm("asdfagaqewf",""))         # false
    print(isPerm("",""))                    # true
    print(isPerm("fjgodid","fjgodid"))      # true
    print(isPerm("jfigkc","cgkjif"))        # true
    print(isPerm("jgidkwod","foeodof"))     # false
    print(isPerm("a","c"))                  # false