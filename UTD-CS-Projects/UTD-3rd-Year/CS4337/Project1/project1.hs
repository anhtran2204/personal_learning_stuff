module Main where

prompt :: IO ()
prompt = putStrLn "Please enter the expression: "

error :: IO ()
error = putStrLn "Invalid Expression"



main :: IO ()
main = do 
    prompt