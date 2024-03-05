module Main where
    import Data.List

    history :: [Int]
    history = []

    add_to_history :: Int -> [Int]
    add_to_history value = history ++ [value]

    get_from_history :: Int -> Int
    get_from_history n = history !! (n - 1)

    parse_expression :: [String] -> Either String (Int, [String])
    parse_expression [] = Left "Empty expression"
    parse_expression (token:tokens)
        | token == "+" = do
            (val1, tokens1) <- parse_expression tokens
            (val2, tokens2) <- parse_expression tokens1
            return (val1 + val2, tokens2)
        | token == "*" = do
            (val1, tokens1) <- parse_expression tokens
            (val2, tokens2) <- parse_expression tokens1
            return (val1 * val2, tokens2)
        | token == "/" = do
            (val1, tokens1) <- parse_expression tokens
            (val2, tokens2) <- parse_expression tokens1
            if val2 == 0
            then Left "Division by zero"
            else return (val1 `div` val2, tokens2)
        | token == "-" = do
            (val1, tokens1) <- parse_expression tokens
            return (-val1, tokens1)
        | "$" `isPrefixOf` token = do
            let n = read (drop 1 token) :: Int
            return (get_from_history n, tokens)
        | otherwise = do
            let val = read token :: Int
            return (val, tokens)

    eval_expression :: String -> Either String String
    eval_expression expr = do
        let tokens = words expr
        (result, remaining) <- parse_expression tokens
        if remaining == [] 
            then Right (show (add_to_history result))
            else Left "Invalid Expression"

    main_loop :: IO ()
    main_loop = do
        putStrLn "Enter expression (or type 'exit' to quit): "
        expr <- getLine
        if expr == "exit"
            then return ()
            else do
                case eval_expression expr of
                    Right result -> do
                        putStrLn result
                        main_loop
                    Left error -> do
                        putStrLn error
                        main_loop

    main :: IO ()
    main = main_loop


    -- import Data.Char 
    -- import Data.List (isPrefixOf)

    -- type Token = String
    -- type Tokens = [String]
    -- type History = [Double]

    -- prompt :: IO ()
    -- prompt = putStrLn "Enter expression: "


    -- addToHistory :: [a] -> a -> [a]
    -- addToHistory history value = history ++ [value]

    -- getFromHistory :: Int -> [a] -> Maybe a
    -- getFromHistory n history
    --     | n > 0 && n <= length history = Just (history !! (n - 1))
    --     | otherwise                    = Nothing

    -- parseExpression [] = (Left "Empty expression", [])
    -- parseExpression ()

    -- main :: IO ()
    -- main = do
    --     putStrLn "Enter expression (or type 'exit' to quit): "
    --     expression <- getLine
    --     if expression == "exit" then return ()
    --     else putStrLn expression

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