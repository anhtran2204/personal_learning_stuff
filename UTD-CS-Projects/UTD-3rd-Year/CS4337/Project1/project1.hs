module Main where

prompt :: IO ()
prompt = putStrLn "Please enter the expression: "

error :: IO ()
error = putStrLn "Invalid Expression"

parseExpr :: [Char] -> [Char]
parseExpr [] = []
parseExpr [x] = [x]
parseExpr (x:y:xs) 
    | x == '$' = y : parseExpr xs
    | otherwise = x : parseExpr (y:xs)

main :: IO ()
main = do
    prompt
    expression <- getLine
    putStrLn ("Expression: " ++ expression)
    print (parseExpr expression)