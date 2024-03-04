module Main where

    type History = [Double]

    prompt :: IO ()
    prompt = putStrLn "Enter expression: "

    
    addToHistory :: [a] -> a -> [a]
    addToHistory history value = history ++ [value]

    getFromHistory :: Int -> [a] -> Maybe a
    getFromHistory n history
        | n > 0 && n <= length history = Just (history !! (n - 1))
        | otherwise                    = Nothing

    parseExpression = 

    main :: IO ()
    main = do
        prompt
        expression <- getLine
        putStrLn expression


    -- import Data.Maybe (fromJust)

    -- -- Function to check if a character is an operator
    -- isOperator :: Char -> Bool
    -- isOperator c = c `elem` "+-/*"

    -- -- Function to perform the actual calculation
    -- calculate :: Char -> Int -> Int -> Int
    -- calculate op a b = case op of
    --     '+' -> a + b
    --     '*' -> a * b
    --     '/' -> a `div` b
    --     _   -> error "Unsupported operator"

    -- -- Unary operation for negation
    -- negateValue :: Int -> Int
    -- negateValue = negate

    -- -- Function to evaluate a prefix expression with unary negation
    -- evalPrefix :: String -> Int
    -- evalPrefix = head . foldr process []
    --     where
    --         process :: Char -> [Int] -> [Int]
    --         process c stack
    --             | c == '-' && length stack == 1 = 
    --                 let a = head stack in negateValue a : tail stack
    --             | isOperator c = let (a:b:rest) = stack in calculate c a b : rest
    --             | otherwise = digitToInt c : stack

    --         digitToInt :: Char -> Int
    --         digitToInt c
    --             | c `elem` ['0'..'9'] = fromEnum c - fromEnum '0'
    --             | otherwise = error "Invalid digit"

    -- -- Main function to output the calculation result
    -- main :: IO ()
    -- main = do
    --     putStrLn "Enter expression: "
    --     preExp <- getLine
    --     putStrLn $ "Result: " ++ show (evalPrefix preExp)