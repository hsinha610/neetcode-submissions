-- Write your query below
SELECT name from customers where id NOT IN (SELECT customer_id FROM orders)