SELECT *
FROM students
WHERE age >= 12 AND age <= 13;

SELECT s.id, s.name, s.age
FROM students as s
WHERE s.name LIKE '%G%';

SELECT name
FROM students;

SELECT *
FROM students
WHERE name LIKE '%o%';

SELECT *
FROM students
WHERE age < id;

SELECT *
FROM students
ORDER BY age asc;

SELECT s.id, s.name, s.age, s.faculty_id
FROM students as s, faculties as f
WHERE s.faculty_id = f.id AND s.faculty_id = 1;