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

main :: IO()
main = print (classAverages [
    (80.4,79.8,89.3,90.5),
    (87.4,65.2,74.6,76.1),
    (81.4,75.2,94.6,86.1),
    (67.4,55.2,74.6,86.1)])