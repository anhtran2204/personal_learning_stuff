def ascii_string(list, ascii_code):
    char = chr(ascii_code)
    list.append(char)
	
list = []
ascii_string(list, 104)
ascii_string(list, 101)
ascii_string(list, 108)
ascii_string(list, 108)
ascii_string(list, 111)
ascii_string(list, 32)
ascii_string(list, 119)
ascii_string(list, 111)
ascii_string(list, 114)
ascii_string(list, 108)
ascii_string(list, 100)

str = ""
for x in list:
    str += x
print(str)