{\rtf1\ansi\ansicpg1252\cocoartf2511
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fnil\fcharset0 HelveticaNeue;\f1\fnil\fcharset0 HelveticaNeue-Italic;}
{\colortbl;\red255\green255\blue255;\red0\green0\blue0;}
{\*\expandedcolortbl;;\cssrgb\c0\c0\c0;}
\margl1440\margr1440\vieww25400\viewh13460\viewkind0
\deftab720
\pard\pardeftab720\sl340\sa280\partightenfactor0

\f0\fs28 \cf2 \expnd0\expndtw0\kerning0
\outl0\strokewidth0 \strokec2 Money Application Test Document\
\
Exploratory testing :\
Most features of application work as expected or as end user would expect them to be.\
Application does miss a signup page this could be on purpose or a feature flag that\'92s turned off my assumption app keeps track of info using users device storage however on deleting and reinstalling it clears it out similar to cookies on browser. But that does not happen when you close and relaunch the application. \
Application has some confusing components that aren\'92t as straight forward as they should be for end user, few I noticed \
1: Negative balance shown in red oppose to showing a \'93-\'93 sign next to it, a minus sign easily signifies balance being in negative instead of red highlight. \
2: Deleting balance is a 3 step process a simple swipe left with pop up message or swipe left with message integration in swipe would be more user friendly.\
3: Daily Budget shows total sum of expense out of daily set amount instead of showing \
4:  Application does take few minutes of sitting and learning not as straight forward as competitor apps or not guided as much.\
5: Data leak and hack can be a huge liability. \
\
Test Strategy:\
Unit Testing: Devs to write unit test for each function that is to make to production and code review. \
Component Testing or Api Testing: Depending if application is monolithic or micro-services we should test its functions individually before integrating them into UI.\
End To End Testing: Automation and manual testing of whole UI, covering every feature. making sure of regression cases as well. \
\
Test Suit:\
\pard\pardeftab720\sl340\sa280\partightenfactor0
\cf2 \outl0\strokewidth0 In Scope Automation: \outl0\strokewidth0 \
\pard\pardeftab720\sl340\sa280\partightenfactor0
\cf2 Component Testing\
Verify features through api testing to catch early bugs or errors:\
\pard\pardeftab720\sl340\sa280\partightenfactor0
\cf2 \outl0\strokewidth0 1: Test adding and deducting Balance feature.\

\f1\i   Post request to add balance status code 201 expected and Get request with body to see if balance was updated correctly status code 200 expected\
 API\{EXAMPLE.API?=CAL\}
\f0\i0 \
 2: Test adding expense feature. \
\pard\pardeftab720\sl340\sa280\partightenfactor0

\f1\i \cf2  Post request to add expense status code 201 expected and get request to see if balance was updated correctly  status code 200 expected\
 API\{EXAMPLE.API?=CAL\}
\f0\i0 \
\pard\pardeftab720\sl340\sa280\partightenfactor0

\f1\i \cf2 3: New expense add showing correct adjusted balance and correct widget. \
\pard\pardeftab720\sl340\sa280\partightenfactor0
\cf2  Post request to on a car/house/food expense status code 201 expected and get request to see if balance was updated correctly status code 200 expected\
 API\{EXAMPLE.API?=Home/balance\}\
\pard\pardeftab720\sl340\sa280\partightenfactor0

\f0\i0 \cf2 4: Testing balance transfer within two accounts\

\f1\i Post request on balance with parameters of account and status code 201 expected\
\

\f0\i0 \outl0\strokewidth0 Smoke Testing. UI \
\pard\pardeftab720\sl340\sa280\partightenfactor0
\cf2 Verify critical components with UI integration of application. \
1: Test adding and deducting Balance feature.\
 
\f1\i Scenario:  When a user clicks on balance button user should be shown calculator where user can add balance or do whatever addition they need to get their desired balance this should work on all adding balance buttons on app and balance should be updated to its respective parts (cash, credit card accounts etc)\
expected result: adding balance should show correct balance throughout the app.
\f0\i0 \
2: Test adding expense feature. \
Scenario: When a user clicks on any widget of expense or clicks on minus sign  
\f1\i \outl0\strokewidth0 user should be shown calculator where user can deduct balance or do whatever calculator usage they need to and should always see their correct adjusted balance this should work on all expense balance buttons on app and balance should be updated to its respective parts (widgets, total amount, cash, credit card accounts etc)\
Expected Result: adding expense should show correct balance throughout the app.
\f0\i0 \outl0\strokewidth0 \
3: Testing widgets are correct widget to its respective name.\

\f1\i Scenario: All widgets have their unique name and icon to make it easy for user to add or modify expense. these widgets should always be showing to correct name and icon \
for example car should show image of car \
taxi should show taxi\
Expected Result: Correct images to widget name
\f0\i0 \

\f1\i 4: New expense add showing correct adjusted balance and correct widget. \
Scenario: User clicks on widgets to add expenses \
Expected Result: Every time user adds expense using widget it should update the widget with its expense and update the total balance. \

\f0\i0 5: Testing balance transfer within two accounts\

\f1\i Scenario: User transfer balance from cash to any other account or vise versa\
Expected Result: user should see correct amount transferred and updated balance on both accounts \

\f0\i0 6: Testing the calculator\

\f1\i Running multiple different calculation script with assertion to check correct output, check arithmetic operations, verify correct outputs.\

\f0\i0 \
}
