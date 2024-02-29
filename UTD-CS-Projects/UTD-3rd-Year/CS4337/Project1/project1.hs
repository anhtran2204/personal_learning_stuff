module Main where

    import Data.Char ( isDigit )

    prompt :: IO ()
    prompt = putStrLn "Please enter the expression: "


    prefixCalc :: [Char] -> IO ()
    prefixCalc [] = putStrLn "End of expression"
    prefixCalc (x:xs)
        | x == '+' =  do
            putStrLn "Addition"
            prefixCalc xs
        | x == '-' = do
            putStrLn "Subtraction"
            prefixCalc xs
        | x == '*' = do
            putStrLn "Multiplication"
            prefixCalc xs
        | x == '/' = do
            putStrLn "Division"
        | otherwise = do
            putChar x
            putChar '\n'
            prefixCalc xs

        

    main :: IO ()
    main = do
        prompt
        expression <- getLine
        putStrLn ("Expression: " ++ expression)
        prefixCalc expression