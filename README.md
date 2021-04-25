# MatchMaker
Matrimony like Console app

## Problem Statement

Develop a simple console app 'MatchMaker' which will match prospective brides & grooms according to their preferences.

Keep at least 5 users' data in the in-memory database or a json file for matching purposes.

Ask user to enter following details:
1. Full name
2. Age in years
3. Gender
4. Profession
5. District
6. Hobbies
7. Partners preferred Gender
8. Partners preferred professions
9. Partners preferred age-range (inclusive range)

Only following professions & districts are allowed:
1. Allowed professions: Engineer, Doctor, Lawyer, CA, Teacher, Farmer, BusinessPerson, Marketing
2. Allowed districts: Amravati, Yavatmal, Akola, Wardha, Nagpur, Washim, Buldhana, Nanded

Following is the list of district names and their nearby districts
District -> Nearby Districts
1. Amravati -> (Yavatmal, Akola, Wardha, Washim)
2. Yavatmal -> (Amravati, Wardha, Washim, Nanded)
3. Akola -> (Amravati, Buldhana, Washim)
4. Wardha -> (Yavatmal, Amravati, Nagpur)
5. Nagpur -> (Wardha)
6. Washim -> (Yavatmal, Akola, Amravati, Nanded)
7. Buldhana -> (Yavatmal, Akola, Wardha, Washim)
8. Nanded -> (Yavatmal, Akola, Wardha, Washim)

###Rules for matching:

A. Hard rules: These rules must match for a match to happen:
1. Age should be in the preferred age-range
2. Gender should match the partners preferred gender
  
B. Soft rules: Those rules will be evaluated on the points basis. 
Total points should be more than 15 for a match to happen.
1. Each other's profession should be in each other's preferred professions (6 points for each matched profession)
2. Each other's district should be nearby (12 points if true)
3. Matching hobbies (4 points for each common hobby)

Display the names of matches along-with total points as an output.
If no profile matches then display "There are no matching profiles"
