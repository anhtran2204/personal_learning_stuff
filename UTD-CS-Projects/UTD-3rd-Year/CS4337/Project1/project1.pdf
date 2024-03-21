{-# OPTIONS_GHC -Wno-unrecognised-pragmas #-}
{-# HLINT ignore "Use camelCase" #-}
module Main where
    import Data.List ( isPrefixOf )
    import Data.Char ( digitToInt, isDigit )

    history :: [Int]
    history = []

    add_to_history :: Int -> [Int]
    add_to_history value = value : history

    get_from_history :: Int -> [Int] -> Int
    get_from_history n list = list !! (n - 1)

    parse_expression :: [Char] -> [Int] -> Either String (Int, [Char])
    parse_expression [] _ = Left "Empty expression"
    parse_expression (token:tokens) list
        | token == '+' = do
            (val1, tokens1) <- parse_expression tokens list
            (val2, tokens2) <- parse_expression tokens1 list
            return (val1 + val2, tokens2)
        | token == '*' = do
            (val1, tokens1) <- parse_expression tokens list
            (val2, tokens2) <- parse_expression tokens1 list
            return (val1 * val2, tokens2)
        | token == '-' = do
            (val1, tokens1) <- parse_expression tokens list
            return (-val1, tokens1)
        | token == ' ' =
            parse_expression tokens list
        | token == '$' = do
            let n = digitToInt (head tokens)
            return (get_from_history n list, drop 1 tokens)
        | otherwise  = do
            let val = digitToInt token
            return (val, tokens)

    eval_expression :: String -> [Int] -> Either String [Int]
    eval_expression expr list = do
        (result, remaining) <- parse_expression expr list
        if null remaining
        then Right (add_to_history result)
        else Left "Extraneous expression"

    printHistory :: [Int] -> Int -> IO ()
    printHistory [] _ = putStr ""
    printHistory (x:xs) id = do
        putStr "Id: "
        print id
        putStr "- "
        print x
        printHistory xs (id+1)

    main_loop :: [Int] -> IO ()
    main_loop list = do
        putStrLn "Enter expression (or type 'exit' to quit): "
        expr <- getLine
        if expr == "exit"
        then return ()
        else do
            case eval_expression expr list of
                Right result -> do
                    putStr "= "
                    print result
                    let new_history = list ++ result
                    printHistory new_history 1
                    main_loop new_history
                Left error -> do
                    putStrLn error
                    putStrLn ""
                    main_loop []

    main :: IO ()
    main = main_loop []