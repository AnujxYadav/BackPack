# Backpack
![image](https://user-images.githubusercontent.com/76813122/148958349-9c5e8e55-93d2-4769-ad90-c763a019abb2.png)
This is a command-line app that is used to assign assignments, quizzes and exams to the students. Both Instructor and students can make account on this platform and then can access features given below:

# Menu

- ## INSTRUCTOR
    1. Add class material
    2. Add assessments
    3. View lecture materials
    4. View assessments
    5. Grade assessments
    6. Close assessment
    7. View comments
    8. Add comments
    9. Logout

- ## STUDENT
    1. View lecture materials
    2. View assessments
    3. Submit assessment
    4. View grades
    5. View comments
    6. Add comments
    7. Logout

# Base Logic
## INSTRUCTOR
- Lecture materials may be uploaded and viewed by an instructor. There are two kinds of lecture material:
    - Lecture Videos: A filename ending in.mp4
    - Lecture Slides: An array of strings containing the slides' content.

- Assessments can be uploaded and graded by an instructor. The evaluations might be of two types.
types:
    - Assignments: A problem statement defining the task is required.
    - Quizzes: A single question with a single-word response
- In addition, while submitting an assignment, a teacher will set the maximum number of points.
feasible for that assignment, which will be utilised when the work is graded by an instructor
submissions. The maximum score for a quiz is 1, by default.
- An instructor will also be required to end an assessment after which no further submissions will be accepted.
will be considered

#
## STUDENT
- A student can view the uploaded lecture material
- A student should be able to view assessments and upload submissions which will be
graded by the instructor. The format of submissions will be as follows:
    - Assignments: A filename with extension .zip (eg: sample_submission.zip)
    - Quiz: A one-word solution to the question
- Students can check if their submission has been graded, and marks received for the
same.
#

## COMMON FUNCTIONS
Discussions in online forums are an essential component of any active learning environment. To make this easier, everyone should be able to post comments on a course discussion thread. Every participant of the course, including instructors and students, should be able to add and read other people's remarks. Comments should be displayed when viewing, together with the name of the individual who added them and the timestamp of the remark. In contrast to Google Classroom, where we may contribute comments to evaluations and lesson materials. For the time being, BYLD would want you to set up a simple discussion forum where members may add and see comments.


#
