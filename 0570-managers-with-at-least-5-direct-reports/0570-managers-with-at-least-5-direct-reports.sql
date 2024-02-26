# Write your MySQL query statement below
SELECT name FROM Employee WHERE id IN (SELECT managerId FROM EMPLOYEE GROUP BY managerId HAVING COUNT(id) >= 5);