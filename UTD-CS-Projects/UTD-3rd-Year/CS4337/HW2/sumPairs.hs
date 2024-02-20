pair :: [Int] -> [Int]
pair [] = []
pair [x] = [x]
pair (k:v:t) = (k + v) : pair t

