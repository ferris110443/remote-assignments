-- 1. Write an SQL statement to select all articles with their author’s email.

SELECT user_information.email, user_article.title, user_article.content
FROM user_information
         JOIN user_article
              ON user_information.id = user_article.author_Id;

-- 2. Write another SQL statement to select articles from 7th to 12th sorted by id.

SELECT user_article.id, user_information.email, user_article.title, user_article.content
FROM user_information
         JOIN user_article
              ON user_information.id = user_article.author_Id
WHERE user_article.id BETWEEN 7 AND 12
ORDER BY user_article.id ASC;