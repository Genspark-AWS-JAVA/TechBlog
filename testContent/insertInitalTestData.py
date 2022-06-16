import requests
import json

usersUrl = "http://localhost:8080/users/"
articlesUrl = "http://localhost:8080/articles/"

headers = {
    'Content-Type': 'application/json',
    'Cookie': 'JSESSIONID=7415D4A21310EE9837149D851CB6E1BD'
}

# get users and articles from content.json and insert them into the database
with open('testContent/content.json') as json_file:
    data = json.load(json_file)
    users_data = data.get('users')
    for users in users_data:
        user_data = {
            "username": users.get('username'),
            "firstName": users.get('firstName'),
            "lastName": users.get('lastName'),
            "email": users.get('email'),
        }
        response = requests.post(usersUrl,
                                 data=json.dumps(user_data),
                                 headers=headers)
        print(response.text)
        print(response.status_code)
        print("\n")
    articles_data = data.get('articles')

    article_ids = []

    for article in articles_data:
        article_data = {
            "title": article.get('title'),
            "content": article.get('content'),
            "username": article.get('username'),
        }
        response = requests.post(articlesUrl,
                                 data=json.dumps(article_data),
                                 headers=headers)
        article_ids.append(response.json().get('id'))
        print(response.text)
        print(response.status_code)
        print("\n")
    comments_data = data.get('comments')
    i = 0
    for comment in comments_data:
        comment_data = {
            "content": comment.get('content'),
            "title": comment.get('title'),
        }
        response = requests.post(articlesUrl + str(article_ids[i]) + "/comments",
                                    data=json.dumps(comment_data),
                                    headers=headers)
        i += 1
        print(response.text)
        print(response.status_code)
        print("\n")