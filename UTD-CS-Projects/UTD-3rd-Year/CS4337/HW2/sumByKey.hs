sumByKey :: [(Int, Int)] -> (Int, Int)
sumByKey pairs = sumByKeyHelper pairs (0, 0)
  where
    sumByKeyHelper [] acc = acc
    sumByKeyHelper ((k,v):xs) (sum0, sum1)
      | k == 0 = sumByKeyHelper xs (sum0 + v, sum1)
      | k == 1 = sumByKeyHelper xs (sum0, sum1 + v)
      | otherwise = error "Invalid key found. Only 0 or 1 are allowed."