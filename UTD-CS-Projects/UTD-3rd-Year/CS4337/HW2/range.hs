range :: (Ord t, Num t) => t -> t -> [t]
range x y
    | x > y = []
    | x == y = [y]
    | otherwise = x : range (x + 1) y
