-- Exams: 30%; Homework: 30%; Projects: 30%; Quizzes: 10%
classAverages :: Fractional b => [(b, b, b, b)] -> [b]
classAverages students = zipWith (*) weights (map (/ fromIntegral (length students)) (classTotals students))
    where 
        weights = [0.3,0.3,0.3,0.1] 
        classTotals :: (Num a) => [(a, a, a, a)] -> [a]
        classTotals students = classAveragesHelper students [0, 0, 0, 0]
                where
                classAveragesHelper [] acc = acc
                classAveragesHelper ((a,b,c,d):xs) [exams, homework, projects, quizzes]
                    = classAveragesHelper xs [exams + a, homework + b, projects + c, quizzes + d]