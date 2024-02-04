-- 1. Write an SQL statement to select all articles with their author’s email.

SELECT inf.email, art.title, art.content
FROM user_information AS inf
         JOIN user_articles AS art
              ON inf.user_information_id = art.user_information_id;

-- 2. Write another SQL statement to select articles from 7th to 12th sorted by id.

SELECT art.user_article_id, inf.email, art.title, art.content
FROM user_information AS inf
         JOIN user_articles AS art
              ON inf.user_information_id = art.user_information_id
WHERE art.user_article_id BETWEEN 7 AND 12
ORDER BY art.user_article_id ASC;