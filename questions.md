>Further questions
As you take on the assignment you will undoubtedly have questions. Please write these questions down in a file named questions.md and submit that along with your solution. Although we cannot answer them in order for you to complete the assignment, they will be helpful in evaluating your solution.

**Please find my questions listed below:**

+ ##### Functional requirement clarification:
1. As pre requirement "Congestion tax is charged during fixed hours for vehicles driving into and out of Gothenburg." What does the "driving into and out of " exactly mean? Does it mean tax will be charged only if location changes happened? 

2. Is it possible that the "The Single Charge Rule" will be combined with other rules at the same time?

3. As per requirement "The tax is not charged on weekends (Saturdays and Sundays), public holidays, days before a public holiday and during the month of July." does it follow the same rule amoung different City, or diffent rule?

4. Apart from  a City ,such as Gothenburg, is there any other area (e.g. district) will have to use different tax fee logic?

5. Is there any other fee calculation coexisted in system which need to be considered.

+ ##### Non-functional requirement clarification:
1. How many users will use the system and how many users will use the system simultaneously.

2. Is there any security concern of system? For instance, all request of rest call should be encrypted before sending to backend?

3. How does the program be launched in production enviromen? It is more likely that it run by batch job and feed with timeline data than to use rest call.

4. Assume that vehicle will not be changed frequently ,while city and toll fee rule configure will it be changed frequently? 

5. How many list of city involved in system, for performance reason, it should be cache and will be updated on demand at low frequency.

