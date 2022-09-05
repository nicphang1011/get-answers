-- Write one raw sql query that fulfils the following condition using the same schema as Question 7
-- • is of a category that the user like
-- • user have not purchased a ticket for this event
-- • happening within the next 60 days
-- • have not sold out

SELECT * FROM `Event` as e INNER JOIN  User_like on e.category = User_like.category 
LEFT JOIN  Ticket_type as tt ON e.id = tt.event_id WHERE DATEDIFF(CURDATE(), start_datetime) <= 60 AND capacity > 0
LEFT JOIN `Transaction` as txn on User_like.user_id = txn.user_id WHERE txn.id IS NULL