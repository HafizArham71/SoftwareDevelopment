#include <iostream>
#include <iomanip>
#include <sstream>
#include <string>
using namespace std;

//Function Prototypes
void displayWelcomeScreen();
void displaySubjectsMenu();
void inputTheoryMarks();
void inputLabMarks();
void calculateEarnedWeightage(bool isLab);
void calculateGpa();

int getSubjectChoice(string prompt);
void theorySetup(int &noOfQuizes, int &noOfAssignments);
void quizesMarks(int noOfQuizes);
void assignmentMarks(int noOfAssignments);
float getValidMarks(string prompt);
void examsMarks();
bool isAnyLab(string prompt);
float calculateTheoryWeightage(int weight);
float calculateLabWeightage();
string mapToGrade();
float mapToGPA();
string mapToRemarks(string grade);
string getAcademicStatus(float pct, float gpa);

// Variables
struct student
{
    float sumOfObtQuizMarks;
    float sumOfTotalQuizMarks;
    float sumOfObtAssignMarks;
    float sumOfTotalAssignMarks;
    float midObtMarks;
    float midTotalMarks;
    float finalObtMarks;
    float finalTotalMarks;

    float labObtAssignPlusQuiz;
    float labTotalAssignPlusQuiz;
    float labObtMidMarks;
    float labTotalMidMarks;
    float labObtFinalMarks;
    float labTotalFinalMarks;

    float totalCoursePercentage;
};

student semester;
string subjectName;

// Main Function starts from here!
int main()
{
    displayWelcomeScreen();
    bool again;
    do
    {
        displaySubjectsMenu();
        inputTheoryMarks();
        cout << "---------------------------------" << endl;
        cout << "> Step 6: Lab Component Check" << endl;
        cout << "---------------------------------" << endl;
        bool isLab = isAnyLab("Does this subject include a lab component? (y/n): ");
        if(isLab) inputLabMarks();
        calculateEarnedWeightage(isLab);
        calculateGpa();
        cout << "\n---------------------------------------------------------------" << endl;
        again = isAnyLab("Do you want to calculate GPA for another subject? (y/n): ");
    }while(again);

    cout << "\n==================================" << endl;
    cout << "THANK YOU FOR USING THE GPA SYSTEM!" << endl;
    cout << "==================================" << endl;

    return 0;
}//End Main

//Function: Welcome screen
void displayWelcomeScreen()
{
    cout << "======================================================================" << endl;
    cout << "          COMSATS UNIVERSITY LAHORE - GPA CALCULATOR (2025)           " << endl;
    cout << "======================================================================" << endl << endl;

    cout << "Instructions:" << endl;
    cout << "  - Enter your marks accurately." << endl;
    cout << "  - Follow each step carefully." << endl;
    cout << "  - GPA is calculated using COMSATS' official weightage and grading scale." << endl << endl;
}
//Function: Display Menu
void displaySubjectsMenu()
{
    cout << "---------------------------------" << endl;
    cout << "> Step 1: Select Your Subject" << endl;
    cout << "---------------------------------" << endl;
    cout << "  [1] Programming Fundamentals [PF]" << endl;
    cout << "  [2] Information And Communication Technology [ICT]" << endl;
    cout << "  [3] Applied Physics" << endl;
    cout << "  [4] Functional English" << endl;
    cout << "  [5] Islamic Studies" << endl << endl;

    int choice = getSubjectChoice("Enter subject number (1-5): ");

    switch(choice)
    {
        case 1: subjectName = "PF"; break;
        case 2: subjectName = "ICT"; break;
        case 3: subjectName = "Physics"; break;
        case 4: subjectName = "English"; break;
        case 5: subjectName = "Islamiat"; break;
        default: cout << "Wrong Choice.\n";
    }

    cout << "You selected: " << subjectName << endl << endl;
}

//Function: Theory Marks Input
void inputTheoryMarks()
{
    int noOfQuizes, noOfAssignments;

    theorySetup(noOfQuizes, noOfAssignments);

    quizesMarks(noOfQuizes);
    assignmentMarks(noOfAssignments);
    examsMarks();
}
//Function: Lab Marks Input
void inputLabMarks()
{
    int noOfAssign;
    float num1, num2, sum1=0, sum2=0;
    cout << "-----------------------------" << endl;
    cout << "> Step 7: Lab Marks Input" << endl;
    cout << "-----------------------------" << endl;

    noOfAssign = getValidMarks("Number of Assignments: ");
    cout << endl;

    for(int i=0; i<noOfAssign; i++)
    {
        cout << "ASSIGNMENT : " << i+1 << endl;
        num1 = getValidMarks("  - Obtained : ");
        num2 = getValidMarks("  - Total    : ");
        sum1+=num1;
        sum2+=num2;
    }
    semester.labObtAssignPlusQuiz = sum1;
    semester.labTotalAssignPlusQuiz = sum2;

    cout << endl;
    cout << "LAB MID-TERM : " << endl;
    semester.labObtMidMarks   = getValidMarks("  - Obtained : ");
    semester.labTotalMidMarks = getValidMarks("  - Total    : ");
    cout << endl;
    cout << "LAB FINAL-TERM : " << endl;
    semester.labObtFinalMarks   = getValidMarks("  - Obtained : ");
    semester.labTotalFinalMarks = getValidMarks("  - Total    : ");

    cout << endl << endl;
}
//Function: Calculating Theory Weightage
void calculateEarnedWeightage(bool isLab)
{
    float theoryWeightage, labWeightage;

    if(!isLab)
    {
        theoryWeightage = calculateTheoryWeightage(100);
        cout << "----------------------------------------------------------------------" << endl;
        cout << "FINAL COURSE PERCENTAGE :    " << theoryWeightage << "%" << endl << endl;
        semester.totalCoursePercentage = theoryWeightage;
    }
    else
    {
        theoryWeightage = calculateTheoryWeightage(75);
        labWeightage = calculateLabWeightage();
        cout << endl;
        cout << "FINAL COURSE PERCENTAGE :    " << theoryWeightage+labWeightage << "%" << endl << endl;
        semester.totalCoursePercentage = theoryWeightage+labWeightage;
    }
}

void calculateGpa()
{
    char totalEarn[20];
    sprintf(totalEarn, "%.2f%%", semester.totalCoursePercentage);

    cout << "=====================================" << endl;
    cout << "GPA MAPPING BASED ON COMSATS SCALE" << endl;
    cout << "======================================" << endl << endl;
    cout << " ===================================" << endl;
    cout << left << "| " << setw(20) << "COURSE NAME"
        << "| " << setw(12) << subjectName << "|" << endl;
    cout << "|=====================|=============|" << endl;
    cout << left << "| " << setw(20) << "FINAL PERCENTAGE"
        << "| " << setw(12) << totalEarn << "|" << endl;
    cout << "|=====================|=============|" << endl;
    cout << left << "| " << setw(20) << "LETTER GRADE"
        << "| " << setw(12) << mapToGrade() << "|" << endl;
    cout << "|=====================|=============|" << endl;
    cout << left << "| " << setw(20) << "MAPPED GPA"
        << "| " << fixed << setprecision(2) << mapToGPA() << " / 4.00 |" << endl;
    cout << "|=====================|=============|" << endl;
    cout << left << "| " << setw(20) << "ACADEMIC STATUS"
        << "| " << setw(12) << getAcademicStatus(semester.totalCoursePercentage, mapToGPA()) << "|" << endl;
    cout << "|=====================|=============|" << endl;
    cout << left << "| " << setw(20) << "REMARKS"
        << "| " << setw(12) << mapToRemarks(mapToGrade()) << "|" << endl;
    cout << " ===================================" << endl << endl;

    cout << "NOTES:\n- GPA calculation is based on COMSATS University Lahore's official 2025 policy.\n- Minimum passing percentage: 50%\n- Minimum passing GPA      : 2.00" << endl;
}


//Helpers
int getSubjectChoice(string prompt)
{
    bool isValid = false;
    int choice;
    do
    {
        try
        {
            cout << prompt;
            cin >> choice;

            if(cin.fail() || choice<0 || choice>5)
            {
                cin.clear();
                cin.ignore(1000, '\n');
                throw string("[!]Error. Must be a valid digit should be between 0 and 5.\n");
            }
            isValid = true;
            return choice;
        }catch(const string e)
        {
            cout << e;
        }
    }while(!isValid);
}

void theorySetup(int &noOfQuizes, int &noOfAssignments)
{
    cout << "------------------------------------" << endl;
    cout << "> Step 2: Setup Theory Component" << endl;
    cout << "------------------------------------" << endl << endl;

    noOfAssignments = getValidMarks("Number of Assignments : ");
    noOfQuizes = getValidMarks("Number of Quizzes     : ");
}
void quizesMarks(int noOfQuizes)
{
    cout << "-------------------------------------------------" << endl;
    cout << "> Step 3: Enter Quiz Marks (Obtained / Total)" << endl;
    cout << "-------------------------------------------------" << endl << endl;

    float sumOfObtQuizMarks = 0, sumOfTotalQuizMarks = 0, num1, num2;
    for(int i=0; i<noOfQuizes; i++)
    {
        cout << "QUIZ : " << i+1 << ": " << endl;
        num1 = getValidMarks("  - Obtained : ");
        num2 = getValidMarks("  - Total    : ");

        sumOfObtQuizMarks+=num1;
        sumOfTotalQuizMarks+=num2;
    }
    semester.sumOfObtQuizMarks = sumOfObtQuizMarks;
    semester.sumOfTotalQuizMarks = sumOfTotalQuizMarks;
    cout << endl;
}

float getValidMarks(string prompt)
{
    bool isValid = false;
    float marks;
    do
    {
        try
        {
            cout << prompt;
            cin >> marks;

            if(cin.fail() || marks<0 || marks>100)
            {
                cin.clear();
                cin.ignore(1000, '\n');
                throw string("[!]Error. Must be a valid number should be between 0 and 100.\n");
            }
            isValid = true;
            return marks;

        }catch(const string e)
        {
            cout << e;
        }
    }while(!isValid);
}
void assignmentMarks(int noOfAssignments)
{
    cout << "-------------------------------------------------------" << endl;
    cout << "> Step 4: Enter Assignment Marks (Obtained / Total)" << endl;
    cout << "-------------------------------------------------------" << endl << endl;

    float sumOfObtAssignMarks = 0, sumOfTotalAssignMarks = 0, num1, num2;
    for(int i=0; i<noOfAssignments; i++)
    {
        cout << "ASSIGNMENT : " << i+1 << endl;
        num1 = getValidMarks("  - Obtained : ");
        num2 = getValidMarks("  - Total    : ");

        sumOfObtAssignMarks+=num1;
        sumOfTotalAssignMarks+=num2;
    }

    semester.sumOfObtAssignMarks = sumOfObtAssignMarks;
    semester.sumOfTotalAssignMarks = sumOfTotalAssignMarks;

    cout << endl;
}
void examsMarks()
{
    cout << "------------------------------" << endl;
    cout << "> Step 5: Enter Exam Marks" << endl;
    cout << "------------------------------" << endl << endl;

    cout << "MID-TERM : " << endl;
    semester.midObtMarks   = getValidMarks("  - Obtained : ");
    semester.midTotalMarks = getValidMarks("  - Total    : ");
    cout << endl;
    cout << "FINAL-TERM : " << endl;
    semester.finalObtMarks   = getValidMarks("  - Obtained : ");
    semester.finalTotalMarks = getValidMarks("  - Total    : ");

    cout << endl;
}
bool isAnyLab(string prompt)
{
    char ch;
    bool isValid = false;

    do
    {
        try
        {
            cout << prompt;
            cin >> ch;

            if(!(ch == 'y' || ch=='Y' || ch=='n' || ch=='N'))
            {
                cin.clear();
                cin.ignore(1000, '\n');
                throw string("[!]Error. Please enter only 'y' or 'n'.\n");
            }
            cout << endl;
            isValid = true;
            if(ch == 'y' || ch=='Y') return true;
            if(ch=='n' || ch=='N') return false;
        }catch(const string e)
        {
            cout << e;
        }
    }while(!isValid);
}
float calculateTheoryWeightage(int weight)
{
    float earnedWeightageInQuizes = (semester.sumOfObtQuizMarks/semester.sumOfTotalQuizMarks)*15;
    float earnedWeightageInAssign = (semester.sumOfObtAssignMarks/semester.sumOfTotalAssignMarks)*10;
    float earnedWeightageInMids = (semester.midObtMarks/semester.midTotalMarks)*25;
    float earnedWeightageInFinals = (semester.finalObtMarks/semester.finalTotalMarks)*50;
    float totalEarnedWeightage = earnedWeightageInQuizes+earnedWeightageInAssign+earnedWeightageInMids+earnedWeightageInFinals;
    float totalEarnedWeightage1 = (earnedWeightageInQuizes+earnedWeightageInAssign+earnedWeightageInMids+earnedWeightageInFinals)*0.75;
    char quizStr[20], assignStr[20], midStr[20], finalStr[20], totalEarn[20], totalEarn1[20];
    sprintf(quizStr, "%.2f%%", earnedWeightageInQuizes);
    sprintf(assignStr, "%.2f%%", earnedWeightageInAssign);
    sprintf(midStr, "%.2f%%", earnedWeightageInMids);
    sprintf(finalStr, "%.2f%%", earnedWeightageInFinals);
    sprintf(totalEarn, "%.2f%%", totalEarnedWeightage1);
    sprintf(totalEarn1, "%.2f%%", totalEarnedWeightage);


    if(weight==75)
    {
        cout << "====================================" << endl;
        cout << "THEORY COMPONENT (75% Weightage)" << endl;
        cout << "====================================" << endl << endl;


        cout << "---------------------------------------------------------------------" << endl;
        cout << left
         << "| " << setw(15) << "Component"
         << "| " << setw(9) << "Obtained"
         << "| " << setw(7) << "Total"
         << "| " << setw(9) << "Weightage"
         << "| " << setw(18) << "Contribution (%)"
         << "|\n";
        cout << "|----------------|----------|--------|----------|-------------------|" << endl;


        cout << left
        << "| " << setw(15) << "Quizzes"
        << "| " << setw(9)  << semester.sumOfObtQuizMarks
        << "| " << setw(7)  << semester.sumOfTotalQuizMarks
        << "| " << setw(9)  << "15%"
        << "| " << setw(18) << fixed << setprecision(2) << quizStr
        << "|" << endl;

        cout << "|----------------|----------|--------|----------|-------------------|" << endl;

        cout << left
        << "| " << setw(15) << "Assignments"
        << "| " << setw(9)  << semester.sumOfObtAssignMarks
        << "| " << setw(7)  << semester.sumOfTotalAssignMarks
        << "| " << setw(9)  << "10%"
        << "| " << setw(18) << fixed << setprecision(2) << assignStr
        << "|" << endl;

        cout << "|----------------|----------|--------|----------|-------------------|" << endl;

        cout << left
        << "| " << setw(15) << "Midterm"
        << "| " << setw(9)  << semester.midObtMarks
        << "| " << setw(7)  << semester.midTotalMarks
        << "| " << setw(9)  << "25%"
        << "| " << setw(18) << fixed << setprecision(2) << midStr
        << "|" << endl;

        cout << "|----------------|----------|--------|----------|-------------------|" << endl;

        cout << left
        << "| " << setw(15) << "Finalterm"
        << "| " << setw(9)  << semester.finalObtMarks
        << "| " << setw(7)  << semester.finalTotalMarks
        << "| " << setw(9)  << "50%"
        << "| " << setw(18) << fixed << setprecision(2) << finalStr
        << "|" << endl;

        cout << "|----------------|----------|--------|----------|-------------------|" << endl;

        cout << left
        << "| " << setw(15) << "THEORY TOTAL"
        << "| " << setw(9)  << "         "
        << "| " << setw(7)  << "       "
        << "| " << setw(9)  << "75%"
        << "| " << setw(18) << fixed << setprecision(2) << totalEarn
        << "|" << endl;
        cout << "---------------------------------------------------------------------" << endl << endl;
        return totalEarnedWeightage1;
    }
    else
    {
        cout << "=====================================" << endl;
        cout << "THEORY COMPONENT (100% Weightage)" << endl;
        cout << "=====================================" << endl << endl;

        cout << "---------------------------------------------------------------------" << endl;
        cout << left
         << "| " << setw(15) << "Component"
         << "| " << setw(9) << "Obtained"
         << "| " << setw(7) << "Total"
         << "| " << setw(9) << "Weightage"
         << "| " << setw(18) << "Contribution (%)"
         << "|\n";
        cout << "|----------------|----------|--------|----------|-------------------|" << endl;

        cout << left
        << "| " << setw(15) << "Quizzes"
        << "| " << setw(9)  << semester.sumOfObtQuizMarks
        << "| " << setw(7)  << semester.sumOfTotalQuizMarks
        << "| " << setw(9)  << "15%"
        << "| " << setw(18) << fixed << setprecision(2) << quizStr
        << "|" << endl;

        cout << "|----------------|----------|--------|----------|-------------------|" << endl;

        cout << left
        << "| " << setw(15) << "Assignments"
        << "| " << setw(9)  << semester.sumOfObtAssignMarks
        << "| " << setw(7)  << semester.sumOfTotalAssignMarks
        << "| " << setw(9)  << "10%"
        << "| " << setw(18) << fixed << setprecision(2) << assignStr
        << "|" << endl;

        cout << "|----------------|----------|--------|----------|-------------------|" << endl;

        cout << left
        << "| " << setw(15) << "Midterm"
        << "| " << setw(9)  << semester.midObtMarks
        << "| " << setw(7)  << semester.midTotalMarks
        << "| " << setw(9)  << "25%"
        << "| " << setw(18) << fixed << setprecision(2) << midStr
        << "|" << endl;

        cout << "|----------------|----------|--------|----------|-------------------|" << endl;

        cout << left
        << "| " << setw(15) << "Finalterm"
        << "| " << setw(9)  << semester.finalObtMarks
        << "| " << setw(7)  << semester.finalTotalMarks
        << "| " << setw(9)  << "50%"
        << "| " << setw(18) << fixed << setprecision(2) << finalStr
        << "|" << endl;

        cout << "|----------------|----------|--------|----------|-------------------|" << endl;

        cout << left
        << "| " << setw(15) << "THEORY TOTAL"
        << "| " << setw(9)  << "         "
        << "| " << setw(7)  << "       "
        << "| " << setw(9)  << "100%"
        << "| " << setw(18) << fixed << setprecision(2) << totalEarn1
        << "|" << endl;

        cout << "---------------------------------------------------------------------" << endl << endl;

        return totalEarnedWeightage;
    }
}
float calculateLabWeightage()
{
    float earnedWeightageInQuizPlusAssign = (semester.labObtAssignPlusQuiz/semester.labTotalAssignPlusQuiz)*25;
    float earnedWeightageInMids = (semester.labObtMidMarks/semester.labTotalMidMarks)*25;
    float earnedWeightageInFinals = (semester.labObtFinalMarks/semester.labTotalFinalMarks)*50;
    float earnedWeightage = (earnedWeightageInQuizPlusAssign+earnedWeightageInMids+earnedWeightageInFinals)*0.25;

    char assignStr[20], midStr[20], finalStr[20], totalEarn[20];
    sprintf(assignStr, "%.2f%%", earnedWeightageInQuizPlusAssign);
    sprintf(midStr, "%.2f%%", earnedWeightageInMids);
    sprintf(finalStr, "%.2f%%", earnedWeightageInFinals);
    sprintf(totalEarn, "%.2f%%", earnedWeightage);

    cout << "=======================" << endl;
    cout << "LAB COMPONENT (25%)" << endl;
    cout << "=======================" << endl << endl;

    cout << "---------------------------------------------------------------------" << endl;
    cout << left
         << "| " << setw(15) << "Component"
         << "| " << setw(9) << "Obtained"
         << "| " << setw(7) << "Total"
         << "| " << setw(9) << "Weightage"
         << "| " << setw(18) << "Contribution (%)"
         << "|" << endl;
    cout << "|----------------|----------|--------|----------|-------------------|" << endl;

    cout << left
        << "| " << setw(15) << "Assignments"
        << "| " << setw(9)  << semester.labObtAssignPlusQuiz
        << "| " << setw(7)  << semester.labTotalAssignPlusQuiz
        << "| " << setw(9)  << "25%"
        << "| " << setw(18) << fixed << setprecision(2) << assignStr
        << "|" << endl;

    cout << "|----------------|----------|--------|----------|-------------------|" << endl;

    cout << left
        << "| " << setw(15) << "Midterm"
        << "| " << setw(9)  << semester.labObtMidMarks
        << "| " << setw(7)  << semester.labTotalMidMarks
        << "| " << setw(9)  << "25%"
        << "| " << setw(18) << fixed << setprecision(2) << midStr
        << "|" << endl;

    cout << "|----------------|----------|--------|----------|-------------------|" << endl;

    cout << left
        << "| " << setw(15) << "Finalterm"
        << "| " << setw(9)  << semester.labObtFinalMarks
        << "| " << setw(7)  << semester.labTotalFinalMarks
        << "| " << setw(9)  << "50%"
        << "| " << setw(18) << fixed << setprecision(2) << finalStr
        << "|" << endl;

    cout << "|----------------|----------|--------|----------|-------------------|" << endl;

    cout << left
        << "| " << setw(15) << "LAB TOTAL"
        << "| " << setw(9)  << "         "
        << "| " << setw(7)  << "       "
        << "| " << setw(9)  << "50%"
        << "| " << setw(18) << fixed << setprecision(2) << totalEarn
        << "|" << endl;

    cout << "---------------------------------------------------------------------" << endl << endl;
        return earnedWeightage;
}
string mapToGrade()
{
    int percent = semester.totalCoursePercentage;
    if (percent >= 85) return "A";
    else if (percent >= 80) return "A-";
    else if (percent >= 75) return "B+";
    else if (percent >= 71) return "B";
    else if (percent >= 68) return "B-";
    else if (percent >= 64) return "C+";
    else if (percent >= 61) return "C";
    else if (percent >= 58) return "C-";
    else if (percent >= 54) return "D+";
    else if (percent >= 50) return "D";
    else return "F";
}
float mapToGPA()
{
    float pct = semester.totalCoursePercentage;
    if (pct >= 85) return 4.00;
    else if (pct >= 80) return 3.66;
    else if (pct >= 75) return 3.33;
    else if (pct >= 71) return 3.00;
    else if (pct >= 68) return 2.66;
    else if (pct >= 64) return 2.33;
    else if (pct >= 61) return 2.00;
    else if (pct >= 58) return 1.66;
    else if (pct >= 54) return 1.30;
    else if (pct >= 50) return 1.00;
    else return 0.00;
}
string mapToRemarks(string grade)
{
    if (grade == "A") return "Outstanding";
    else if (grade == "A-") return "Excellent";
    else if (grade == "B+" || grade == "B") return "Very Good";
    else if (grade == "B-") return "Good";
    else if (grade == "C+" || grade == "C") return "Satisfactory";
    else if (grade == "C-") return "Marginal Pass";
    else if (grade == "D+" || grade == "D") return "Needs Improvement";
    else return "Fail";
}
string getAcademicStatus(float pct, float gpa)
{
    if (pct >= 50 && gpa >= 2.00)
        return "PASS";
    else if (pct >= 50 && gpa < 2.00)
        return "CONDITIONAL PASS (Low GPA)";
    else
        return "FAIL";
}

