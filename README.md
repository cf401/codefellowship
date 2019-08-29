# Challenge Summary
<!-- Short summary or background information -->
- Demonstrate basic understanding of Spring M.V.C.'s OAuth
- Create profile, profiles, profile by id, login, pages.
- Create posts owned by user in a many to one relationship.
- add the ability to follow users and show a feed.

## Challenge Description
<!-- Description of the challenge -->
```
- create a profile page
- create a profile page by user
- login, signup, root protected by Oauth.
- create posts and tie to users.
- create a feed page, with subscribed users' posts.
```

## to run:
- clone repo
- download intellij
- run 'build project'
- navigate on a browser to : http://localhost:8080/albums
### if not on a mac
- in src/main/resources/application.properties 
- add your unique postgres login and password. 

## for basic functionality go to:
- navigate on a browser to : http://localhost:8080/
- You will see the root!  Click Signup or login.
- navigate on a browser to : http://localhost:8080/profile
- You will see your profile page -- you will see all posts for user.
- navigate on a browser to : http://localhost:8080/profile/<number>
- You will see a particular profile page and posts.
- navigate on a browser to : http://localhost:8080/profiles
- You will see all profiles. You can click to subscribe to any
- navigate with the nav bar or browswer to : http://localhost:8080/feed
- you will see all posts from each subscribed person. 

## Credits and Contributions
Nick Paro
Fabian Brooks
Matt Stuhring
Travis Cox
Melfi Perez
@Bomibear
Renee Messick