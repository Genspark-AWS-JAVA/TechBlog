import requests

import json

usersUrl = "http://localhost:8080/users/"
articlesUrl = "http://localhost:8080/articles/"
tagsUrl = "http://localhost:8080/tags/"

headers = {
    'Content-Type': 'application/json',
    'Cookie': 'JSESSIONID=7415D4A21310EE9837149D851CB6E1BD'
}


def insertUsers(data):
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


def insert_articles(data):
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
    return article_ids


def insert_comments(data, article_ids):
    comments_data = data.get('comments')
    i = 0
    for comment in comments_data:
        comment_data = {
            "content": comment.get('content'),
            "title": comment.get('title'),
        }
        response = requests.post(articlesUrl + str(article_ids[i]) +
                                 "/comments",
                                 data=json.dumps(comment_data),
                                 headers=headers)
        i += 1
        i %= len(article_ids)
        print(response.text)
        print(response.status_code)
        print("\n")


def insert_tags(data, article_ids):
    tags_data = data.get('tags')
    i = 0
    for tag in tags_data:
        tag_data = {
            "value": tag.get('value'),
        }
        response = requests.post(tagsUrl,
                                 data=json.dumps(tag_data),
                                 headers=headers)
        response = requests.put(tagsUrl + tag.get('value') + "/articles/" +
                                str(article_ids[i]),
                                data=json.dumps(tag_data),
                                headers=headers)
        i += 1
        i %= len(article_ids)
        print(response.text)
        print(response.status_code)
        print("\n")


def insert_favorite_articles(data, article_ids):
    favorite_users_data = data.get('favorite')
    i = 0
    for favorite_user in favorite_users_data:
        response = requests.put(usersUrl + favorite_user.get('username') +
                                "/favorite/" + str(article_ids[i]),
                                headers=headers)
        i += 1
        i %= len(article_ids)
        print(response.text)
        print(response.status_code)
        print("\n")


# get data from content.json and insert it into the database
with open('testContent/content.json') as json_file:
    data = json.load(json_file)
    insertUsers(data)
    articles_ids = insert_articles(data)
    insert_comments(data, articles_ids)
    insert_tags(data, articles_ids)
    insert_favorite_articles(data, articles_ids)
