doPrint :: IO ()
doPrint = doPrint' 0
    where doPrint' n
            | n < 5 = print n >> doPrint' (n-1)
            | otherwise = return ()

main :: IO ()
main = doPrint