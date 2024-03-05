{-# OPTIONS_GHC -Wno-unrecognised-pragmas #-}
{-# HLINT ignore "Use camelCase" #-}
module Main where
    import Data.List ( isPrefixOf )
    import Debug.Trace ( trace )

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
        | "$" `isPrefixOf` (token:tokens) = do
            let n = read (read $ show (head tokens) :: String) :: Int 
            return (get_from_history n, tokens) 
        | otherwise = do
            let val = read $ show token :: Int 
            return (val, tokens)

    eval_expression :: String -> Either String String
    eval_expression expr = do
        (result, remaining) <- parse_expression expr
        if null remaining
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