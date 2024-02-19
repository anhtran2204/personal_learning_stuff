import Control.Monad.Except

sumByKey :: [(Int, Int)] -> Either String (Int, Int)
sumByKey pairs = sumByKeyHelper pairs (0, 0)
  where
    sumByKeyHelper [] acc = Right acc
    sumByKeyHelper ((k,v):xs) (sum0, sum1)
      | k == 0 = sumByKeyHelper xs (sum0 + v, sum1)
      | k == 1 = sumByKeyHelper xs (sum0, sum1 + v)
      | otherwise = Left "Invalid key found. Only 0 or 1 are allowed."

main :: IO()
main = print (sumByKey [(2,1),(1,2),(1,3),(0,4),(0,3)])