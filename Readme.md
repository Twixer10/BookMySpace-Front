# BookMySpace

Welcome to the BookMySpace project, a Kotlin Compose application that allows users to book spaces. This project follows the principles of Clean Architecture and uses Retrofit for API calls. It is designed to provide a smooth and intuitive user experience.

### Description

BookMySpace is an application that enables users to search, reserve, and manage spaces for various purposes, whether it's for meetings, events, conferences, or other types of spaces. The project is divided into multiple modules to ensure a clear separation of responsibilities and facilitate code maintenance and extension.

### Architecture

The project adheres to the principles of Clean Architecture to ensure organized, scalable, and testable code. It is divided into several layers:

-   **Presentation Layer (UI)**: This layer uses Kotlin Compose to create a reactive and user-friendly interface. Compose components are designed in a modular and customized way to provide an optimal user experience.
    
-   **Domain Layer**: This layer contains the application's business logic, including use cases and entities. It is independent of any technology.
    
-   **Data Layer**: This layer manages API calls using Retrofit. Retrofit simplifies communication with the remote server by transforming HTTP calls into Kotlin methods. The Data Layer module also handles local persistence if necessary.
    

### Using Retrofit

Retrofit is used to make API calls to the remote server. Here's how it works:

1.  Retrofit configuration in the Data Layer module. You can find the configuration in the  `ApiService.kt`  file.

# CI/CD Pipeline for Android Application

This repository contains the GitLab CI/CD configuration for building and testing an Android application. The pipeline is designed to provide a smooth and automated process for continuous integration and continuous delivery.

### Development Guide

If you want to contribute improvements to the CI/CD templates, please follow the development guide at  [GitLab CI/CD Templates Documentation](https://docs.gitlab.com/ee/development/cicd/templates.html).

### GitLab CI/CD Template

This specific CI/CD template can be found at  [Android.gitlab-ci.yml](https://gitlab.com/gitlab-org/gitlab/-/blob/master/lib/gitlab/ci/templates/Android.gitlab-ci.yml). It's based on the template created by Jason Lenny and is inspired by the blog post  [Setting Up GitLab CI for Android Projects](https://about.gitlab.com/2018/10/24/setting-up-gitlab-ci-for-android-projects/).

### Environment

The pipeline uses the following environment setup:

-   **Base Image:**  [eclipse-temurin:17-jdk-jammy](https://hub.docker.com/_/eclipse-temurin).
-   **Android Compile SDK:**  Version 34.
-   **Android Build Tools:**  Version 33.0.2.
-   **Android SDK Tools:**  Version 9477386.

### Before Script

Before running the build and test scripts, the pipeline performs the following tasks:

1.  Updates and installs necessary packages.
2.  Sets up the  `ANDROID_HOME`  environment variable.
3.  Downloads and extracts Android SDK tools.
4.  Installs Android SDK packages required for the app build.

### Pipeline Stages

#### 1. Lint Debug

-   **Stage:**  Build
-   **Description:**  This stage checks the Android code for linting issues.
-   **Artifacts:**  The lint results are stored and can be viewed in  [lint-results-debug.html](https://www.odwebp.svc.ms/app/lint/reports/lint-results-debug.html).

#### 2. Assemble Debug

-   **Stage:**  Build
-   **Description:**  This stage assembles the debug version of the Android application.
-   **Artifacts:**  The debug APK is stored in  [app/build/outputs/](https://www.odwebp.svc.ms/app/build/outputs/).

#### 3. Debug Tests

-   **Stage:**  Test
-   **Description:**  This stage runs unit tests for the Android application. If any test fails, it interrupts the pipeline.
-   **Dependencies:**  Depends on the success of the "Lint Debug" and "Assemble Debug" stages.

# Feature/ReservationPage  Merge  Activity  (Maxime)  
  
### Introduction  
My branch is called "feature/reservationPage" and i created a merge request to merge it into the `dev'  branch.  
  
### Functionality  delivered  
The  "reservationPage"  branch  will  allow  the  user  to  reserve  their  space.  They  will  be  able  to  view  in  detail  all  the  data  and  features  of  the  space  as  well  as  the  chosen  time,  and  be  able  to  reserve  this  space.  
  
### Merge  Details  
- **Branch  Name:**  feature/reservationPage  
- **Target  Branch:**  dev  
- **Merge  Date:**  19/10/2023  
- **Merge  Commit:**  b0b674c8  
- **Status:**  Successfully  merged  
- **Important  Note:**  I  did  not  delete  the  source  branch  post-merge.  
  
I created and merge this merge request, the 19/10/2023. I assigned the merge request to `@ttecher1` for validation. I made few commits because it's a branch that I coded quickly. I did not delete the branch because the functionality is not 100% complete.  
  
### Resolved  Conflict  Details  on  GitLab  
During this merge request I had some conflicts which I resolved on the gitLab graphical interface. It was a small conflict that was quick to resolve, which is why I used the gitLab graphical interface.  
  
### Commands  Executed  step  by  step  
  
**Creation  of  the  branch  :**  
- To  have  the  latest  version  of  the  code  I  pull  dev  with  the  command  **`git  pull  dev`**,  locally  on  the  branch  `dev`  
- To  created  my  branch  `feature/reservationPage`  I  used,  this  command  **`git  checkout  -b  feature/reservationPage`**  from  the  branch  `dev`  
  
**Save  and  commit  changes  :**  
- When  I  add  finished  a  feature,  I  used  this  command,  **`git  add  .`**,  to  add  to  git  all  the  new  and  modified  work  
- And  then  I  committed  the  added  changes  with  this  command  **`git  commit`**,  to  save  them  into  git,  locally  
- After  that,  I  used  the  command  **`git  push,`**  to  push  my  local  code  into  the  GitLab  repo  
  
  
**Merge  Request**  
  
- I  merged  the  `feature/reservationPage  `  into  `dev`  on  the  GitLab  interface,  by  opening  a  merge  request.  
- I  resolved  the  conflicts  on  the  GitLab  interface.  They  were  minor  conflicts  and  were  easy  to  resolve.,  and  then  commit  the  merge,  with  **`git  commit`**.  
- I  approved  the  merge  request,  and  then  successfully  merged  my  branch  into  dev.



# Feature/search  page  Merge  Activity  (Yoann)  
  
### Introduction  
This document show all the details of the merge of the `feature/search_page` branch into the `dev` branch.  
The feature branch was created and mainly developed by the user Yoann yt. TANIERE.  
  
### General  Merge  Details  
- **Branch  Name:**  `feature/search_page`  
- **Target  Branch:**  `dev`  
- **Merge  By:**  Yoann  yt.  TANIERE  
- **Merge  Date:**  19/10/2023  
- **Merge  Commit:**  ca817746  
- **Status:**  Successfully  merged  
- **Details:**  Did  not  delete  the  source  branch  
  
I created and merge this merge request, the 19/10/2023. I requested a review from `@mtanquerel1`, and assigned the merge request to `@ttecher1`.  
Furthermore, I merged it myself because of the lack of time we had at the moment.  
They were no conflicts on the merge request, because I merged the dev branch locally in order to avoid them.  
I did not delete the source branch, because the functionality was not 100% accomplish.  
  
  
### Delivered  functionality  
The main functionality of the `feature/search_page` branch, was to create the search page in mobile application.  
This involves several features:  
- *Search  Button*  :  Creating  a  button,  who  make  the  API  call  to  get  the  result  of  the  search  
- *Date  Input*  :  Creating  an  input  to  select  the  date  for  the  research  of  space  
- *Hours  Inputs*  :  Creating  two  input  to  select  the  start  and  end  date  for  the  research  
- *Number  Input*  :  Creating  an  input  to  select  the  capacity  minimum  of  a  space  for  the  research  
- *Screen*  :  Creating  the  base  screen,  and  place  the  other  components  
  
  
### Commands  Executed  
  
**Creation  of  the  branch  :**  
- To  have  the  latest  version  of  the  code  I  pull  dev  with  the  command  **`git  pull  dev`**,  locally  on  the  branch  `dev`  
- To  created  my  branch  `feature/search_dev`  I  used,  this  command  **`git  checkout  -b  feature/search_page`**  from  the  branch  `dev`  
  
**Save  and  commit  changes  :**  
- When  I  add  finished  a  feature,  I  used  this  command,  **`git  add  .`**,  to  add  to  git  all  the  new  and  modified  work  
- And  then  I  committed  the  added  changes  with  this  command  **`git  commit`**,  to  save  them  into  git,  locally  
- After  that,  I  used  the  command  **`git  push,`**  to  push  my  local  code  into  the  GitLab  repo  
  
**Merge  Locally  :**  
- After  saving  all  change  I  change  to  `dev`  and  use  **`git  pull`**,  to  retrieve  all  the  new  change  of  the  `dev`  branch,  to  be  up-to-date.  
- Then  I  went  back  on  the  `feature/search_page`  branch,  to  them  use  **`git  merge  dev`**,  so  that  my  branch  is  up-to-date  and  does  not  cause  a  conflict  on  GitLab.  
- I  resolved  the  conflicts  on  Android  Studio,  and  then  commit  the  merge,  with  **`git  commit`**.  
  
**Merge  Request**  
  
- I  merged  the  `feature/search_page`  into  `dev`  on  the  GitLab  interface,  by  opening  a  merge  request.  
- I  approved  the  merge  request,  and  then  successfully  merged  my  branch  into  dev.


# Feature/Home page Merge Activity (Antoine)  
  
### Introduction  
This document show all the details of the merge of the `feature/home_page` branch into the `dev` branch.  
  
### General Merge Details  
- **Branch Name:** `feature/home_page`  
- **Target Branch:** `dev`  
- **Merge By:** Antoine ab. BENEY  
- **Merge Date**: 4 weeks ago  
- **Merge Commit:** `4200274d`  
- **Status:** Successfully merged  
- **Details:** Did not delete the source branch  
  
I created and merge this merge request, the 19/10/2023. I requested a review from `@ttecher1`, and assigned the merge request to `@ttecher1`.  
They were no conflicts on the merge request, because I merged the dev branch locally in order to avoid them.  
I didn't delete it because I still had some changes to make.  
  
  
### Delivered functionality  
The main functionality of the `feature/home_page` branch, was to create the home page in mobile application which will be the main page for the user but there are several important features.  
Features:  
- *A search icon* : Which allows, once clicked, to be redirected to yoann's page "search_page"  
- *A carousel* : Which allows scrolling of all the images that come from the api  
- *Title* : Allows my entire team to use the same style of title  
- *Screen* : Creating the base screen, and place the other components  
  
  
### Commands Executed  
  
**Creation of the branch :**  
- To have the latest version of the code I pull dev with the command **`git pull dev`**, locally on the branch `dev`  
- To created my branch I wrote `feature/home_page` I used, this command **`git checkout -b feature/home_page`** from the branch `dev` to have the most up to date branch  
  
**Save and commit changes :**  
- Once I have completed the modifications for a feature I make **`git add .`**, to add to git all the new and modified work  
- And then I committed the added changes with this command **`git commit -m `**, to save them into git, locally  
- After that, I used the command **`git push,`** to push my local code into the GitLab repository  
  
**Merge Locally :**  
- After saving all change I change to `dev` and use **`git pull`**, to retrieve all the new change of the `dev` branch, to be up-to-date.  
- Then I went back on the `feature/home_page` branch, to them use **`git merge dev`**, so that my branch is up-to-date and does not cause a conflict on GitLab.  
- I prefer to resolve conflicts directly on my editor because I am more used to it so I resolved the conflicts on Android Studio, and then commit the merge, with **`git commit`**.  
  
**Merge Request**  
  
- I merged the `feature/home_page` into `dev` on the GitLab interface, by opening a merge request.  
- Thomas who I assigned as a reviewer to look at the changes and agreed that I could merge  
- I approved the merge request, and then successfully merged my branch into dev.

# Feature/create space Merge Activity (Thomas)

### Overview:

This document provides a detailed description of the `feature/createSpace` merge activity. The functionality was developed and merged by Thomas TECHER.
In this document you will find all the detailed information on the procedure followed.

### Merge Details:

-   **Branch Name**:  `feature/createSpace`
-   **Target Branch**:  `dev`
-   **Merge Date**: 29/09/2023
-   **Merge Commit**:  `7620a93e`
-   **Status**: Successfully merged
-   **Important Note**: The source branch was successfully deleted post-merge.

### Participants:

1.  **Developer & Merged by**: Thomas TECHER
    -   **Assignee**: Thomas TECHER
    -   **Reviewer**: No reviewers were assigned for this merge.

### Additional Information:

- A total of 19 changes were made as part of this merge activity.
- Approval of this merger was optional.

### Process

Here are the steps of the process.

#### Repository clone
First, you must clone the repository with the `git clone url` command.

#### Branch
Once this is done, you can change branches with the `git checkout BranchName` command.

To create a new branch, go to the latest, most up-to-date branch: `dev` with the `git checkout dev` command.

Once on the dev branch we do the command `git checkout -b NewBrancheName`
The `-b` parameter allows you to create the branch locally if it does not exist.

Once this is done, the branch is only available locally. We can push it to the repository with the command `git push --set-upstream origin NewBrancheName`

Once all this is done we start implementing the feature on the branch, in my case I implemented the space creation feature on the application.
We can therefore find the entire step by step system of creation there. Also, in my branch we find a fix on the application's textual string call.

Once this is all finished, I get ready to push my work. My colleagues also worked and as a result it may be that my branch is no longer up to date with my base branch: `dev`.

#### Prepare push
I therefore push all the modifications made to my branches with the following command:
`git add .` to add all changes to push
`git commit -m "message"` allows you to commit with a comment to know what was done.
`git push` to send everything to the repository.

Once this is done, I go to the dev branch with `git checkout dev` and I do a `git pull` to retrieve all the changes made to the repository.
Once my `dev` is up to date I go back to my branch with the `git checkout feature/createSpace` command and I do the `git merge dev` command. This command will transfer the changes from the dev branch to my current branch.

#### Conflicts

In my case I did not have any conflict for the merge of this branch. But if I had, I would have had to resolve the conflicts.
I generally use two solutions, either the conflicts are minimal and in this case I can do it via gitlab directly with the conflict editor.
Either the conflicts are quite complex and in this case I do it from my IDE with the conflict editor, generally that of VsCode.

#### Merge request
Once the conflicts are resolved, I push the changes again and go to the gitlab interface to create a merge request.
I select my branch as well as the target branch. If no one has made another commit in the meantime, I shouldn't have a conflict. If everything is ok at the gitlab level, I assign a reviewer to have an outside look, and I look at the git to see if all my changes are ok.
If my reviewer also validates me we estimate that the branch is ready to be merged.
We wait for the pipeline to be completed if there is one, this ensures that everything compiles well.
Throughout the project we use the `cherry-pick` strategy because it is simple and not very intrusive and adapted to our use of git.

Once all of this is complete, we commit the merge request and let git take care of the rest.

After that the development process starts again.



## Special note
This documentation was written by each of the project contributors.
The language chosen is **English** to bring us as close as possible to a business situation.