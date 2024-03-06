{-# OPTIONS_GHC -Wno-unrecognised-pragmas #-}
{-# HLINT ignore "Use camelCase" #-}
module Main where
    import Data.List ( isPrefixOf )
    import Data.Char ( digitToInt, isDigit )

    history :: [Int]
    history = []

    add_to_history :: Int -> [Int]
    add_to_history value = history ++ [value]

    get_from_history :: Int -> Int
    get_from_history n = history !! (n - 1)

    parse_expression :: String -> Either String (Int, String)
    parse_expression [] = Left "Empty expression"
    parse_expression (token:tokens)
        | token == '+' = do
            (val1, tokens1) <- parse_expression tokens 
            (val2, tokens2) <- parse_expression tokens1
            return (val1 + val2, tokens2)
        | token == '*' = do
            (val1, tokens1) <- parse_expression tokens
            (val2, tokens2) <- parse_expression tokens1
            return (val1 * val2, tokens2)
        | token == '/' = do
            (val1, tokens1) <- parse_expression tokens
            (val2, tokens2) <- parse_expression tokens1
            if val2 == 0
            then Left "Division by zero"
            else return (val1 `div` val2, tokens2)
        | token == '-' = do
            (val1, tokens1) <- parse_expression tokens
            return (-val1, tokens1)
        | token == ' ' = 
            parse_expression tokens
        | "$" `isPrefixOf` (token:tokens) = do
            let n = digitToInt (head tokens)
            return (get_from_history n, tokens) 
        | otherwise  = do
            let val = digitToInt token
            return (val, tokens)

    eval_expression :: String -> Either String Int
    eval_expression expr = do
        (result, remaining) <- parse_expression expr
        if null remaining
        then Right result
        else Left "Extraneous expression"

    main_loop :: IO ()
    main_loop = do
        putStrLn "Enter expression (or type 'exit' to quit): "
        expr <- getLine
        if expr == "exit"
        then return ()
        else do
            case eval_expression expr of
                Right result -> do
                    putStr "= "
                    print result
                    putStrLn ""
                    main_loop
                Left error -> do
                    putStrLn error
                    putStrLn ""
                    main_loop

    main :: IO ()
    main = main_loop

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