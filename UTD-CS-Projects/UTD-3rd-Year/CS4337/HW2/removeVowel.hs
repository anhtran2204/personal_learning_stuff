removeVowel :: String -> String
removeVowel "" = ""
removeVowel str = filter (`notElem` "aeiouAEIOU") str