# Write your MySQL query statement below
select name as customers
from customers c
left outer join orders o
on c.id = o.customerId
where o.customerId is null