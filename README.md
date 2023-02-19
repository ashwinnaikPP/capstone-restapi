# capstone-restapi
<b>Project related to Rest API integration.</b>

Register yourself at https://dummyapi.io/. Once registered, you would get access to a bunch of APIs for a blogging application. 

Scenarios Automated:
1. Get the list of users: https://dummyapi.io/data/v1/user?limit=10
2. Create a user: https://dummyapi.io/data/v1/user/create
2.1. Create a user with an already existing email address (negative test): https://dummyapi.io/data/v1/user/create
3. Get the users created under your account: https://dummyapi.io/data/v1/user?created=1
4. Create a post (blog post): https://dummyapi.io/data/v1/post/create
5. Get Post By id: https://dummyapi.io/data/v1/user/{{post_id}}/post?limit=10
6. Delete post by ID: https://dummyapi.io/data/v1/post/{{post_id}}
7. End-To-End Integration test: Create a test that creates a post, and asserts that the post has been created successfully. Deletes the post and makes sure that the post no longer exists.

<b>Cloning a repository:</b>

1. Open Terminal.

2. Change the current working directory to the location where you want the cloned directory.

3. Type git clone, and then paste the URL.

    URL: https://github.com/ashwinnaikPP/capstone-restapi

    $ git clone https://github.com/ashwinnaikPP/capstone-restapi

4. Hit Enter.

<b>Prerequisites</b> :

1. IDE - IntelliJ or Eclipse.

2. Java should be installed.

3. Gradle. How to install Gradle can be found here(https://gradle.org/install/).

<b>How to run the Project:</b>

From terminal run

gradle test
or
gradle runApiTests

