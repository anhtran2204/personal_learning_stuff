def ascii_string(dict, ascii_code):
    char = chr(ascii_code)
    dict[ascii_code] = char

def string_concat(dict, ascii_code):
    str = ""
    for x in ascii_code:
        str += dict[x]
    return str
	
dict = {}
ascii_code = [104, 101, 108, 108, 111, 32, 119, 111, 114, 108, 100]

for code in range(97, 123):
    ascii_string(dict, code)
ascii_string(dict, 32)

print(string_concat(dict, ascii_code))