removeVowel :: String -> String
removeVowel "" = ""
removeVowel str = filter (`notElem` "aeiouAEIOU") str

main :: IO()
main = print (removeVowel "Hello World")