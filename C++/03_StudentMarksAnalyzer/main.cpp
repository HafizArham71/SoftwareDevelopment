#include<iostream>
#include<iomanip>
using namespace std;

// Function Prototypes
void getNoOfStdAndSubFromUser(int &noOfStd, int &noOfSub);
void getMarksOfEachStd(float stdMarksArr[50][50], int rows, int columns);
void displayStdMarks(float stdMarksArr[50][50], int rows, int columns);
void totalAndAvgMarksOfEachStd(float stdMarksArr[50][50], int rows, int columns, float totalMarksOfEachStdArr[], float avgMarksOfEachStdArr[]);
void displayTotalAndAvgMarks(int rows, float totalMarksOfEachStdArr[], float avgMarksOfEachStdArr[]);
void subWiseTotalAndAvgMarks(float stdMarksArr[50][50], int rows, int columns, float subjectWiseTotalMarksArr[], float subjectWiseAvgMarksArr[]);
void displaySubWiseTotalAndAvgMarks(int columns, float subjectWiseTotalMarksArr[], float subjectWiseAvgMarksArr[]);
void highAndLowMarksInClass(float stdMarksArr[50][50], int rows, int columns);

// Main function starts from here
int main()
{
    // Declaring Variables
    float
    stdMarksArr[50][50],
    totalMarksOfEachStdArr[50],
    avgMarksOfEachStdArr[50],
    subjectWiseTotalMarksArr[50],
    subjectWiseAvgMarksArr[50];

    int N, M;

    cout << "===========================\n";
    cout << " STUDENT MARKS ANALYZER\n";
    cout << "===========================\n\n";

    // Get Number of students and subjects from user
    getNoOfStdAndSubFromUser(N, M);

    // Get Marks from user of each student
    getMarksOfEachStd(stdMarksArr, N, M);

    // Display Marks of Students
    displayStdMarks(stdMarksArr, N, M);

    // Total Marks of Each Student
    totalAndAvgMarksOfEachStd(stdMarksArr, N, M, totalMarksOfEachStdArr, avgMarksOfEachStdArr);

    // Display Total and Average marks
    displayTotalAndAvgMarks(N, totalMarksOfEachStdArr, avgMarksOfEachStdArr);

    // Subject wise total and average marks
    subWiseTotalAndAvgMarks(stdMarksArr, N, M, subjectWiseTotalMarksArr, subjectWiseAvgMarksArr);

    // Display Subject-wise Total and Average marks
    displaySubWiseTotalAndAvgMarks(M, subjectWiseTotalMarksArr, subjectWiseAvgMarksArr);

    // Display Highest and lowest marks in the class
    highAndLowMarksInClass(stdMarksArr, N, M);

    cout << "\n========= End of Report =========\n";
}


// Function: Getting number of student and subjects
void getNoOfStdAndSubFromUser(int &noOfStd, int &noOfSub)
{
    // Handle input for number of students
    while (true) {
        cout << "Enter number of students (1-50): ";
        cin >> noOfStd;
        if (noOfStd <= 0 || noOfStd > 50) {
            cout << "[!] Invalid input. Please enter a number between 1 and 50.\n";
        } else {
            break;
        }
    }

    // Handle input for number of subjects
    while (true) {
        cout << "Enter number of subjects (1-50): ";
        cin >> noOfSub;
        if (noOfSub <= 0 || noOfSub > 50) {
            cout << "[!] Invalid input. Please enter a number between 1 and 50.\n";
        } else {
            break;
        }
    }

    cout << "\n>> Setup Complete. Proceeding to data entry...\n\n";
}

// Function: Get marks of Each student
void getMarksOfEachStd(float stdMarksArr[50][50], int rows, int columns)
{
    cout << "==============================\n";
    cout << " Enter Marks for Each Student\n";
    cout << "==============================\n";

    for(int i = 0; i < rows; i++)
    {
        cout << "\n- Student " << (i + 1) << ":\n";
        for(int j = 0; j < columns; j++)
        {
            while (true) {
                cout << "   Enter marks of Subject " << (j + 1) << ": ";
                cin >> stdMarksArr[i][j];
                if (stdMarksArr[i][j] < 0 || stdMarksArr[i][j] > 100) {
                    cout << "    [!] Invalid! Enter between 0 and 100.\n";
                } else {
                    break;
                }
            }
        }
    }
}

// Function: Display Marks of Each Student
void displayStdMarks(float stdMarksArr[50][50], int rows, int columns)
{
    cout << "\n================\n";
    cout << " STUDENT MARKS        \n";
    cout << "==================\n";

    for(int i = 0; i < rows; i++)
    {
        cout << "Student " << (i + 1) << ": ";
        for(int j = 0; j < columns; j++)
        {
            cout << fixed << setprecision(1) << stdMarksArr[i][j] << " ";
        }
        cout << "\n";
    }
}

// Function: Total marks of Each Student
void totalAndAvgMarksOfEachStd(float stdMarksArr[50][50], int rows, int columns, float totalMarksOfEachStdArr[], float avgMarksOfEachStdArr[])
{
    for(int i = 0; i < rows; i++)
    {
        float sum = 0;
        for(int j = 0; j < columns; j++)
        {
            sum += stdMarksArr[i][j];
        }
        totalMarksOfEachStdArr[i] = sum;
        avgMarksOfEachStdArr[i] = sum / columns;
    }
}

// Function: Display total and average marks
void displayTotalAndAvgMarks(int rows, float totalMarksOfEachStdArr[], float avgMarksOfEachStdArr[])
{
    cout << "\n==============================\n";
    cout << " STUDENT TOTAL & AVERAGES\n";
    cout << "==============================\n";

    for(int i = 0; i < rows; i++)
    {
        cout << "Student " << (i + 1) << ": ";
        cout << "Total = " << setprecision(1) << totalMarksOfEachStdArr[i]
             << ", Average = " << avgMarksOfEachStdArr[i] << "\n";
    }
}

// Function: Subject-wise total and average marks
void subWiseTotalAndAvgMarks(float stdMarksArr[50][50], int rows, int columns, float subjectWiseTotalMarksArr[], float subjectWiseAvgMarksArr[])
{
    for(int i = 0; i < columns; i++)
    {
        float sum = 0;
        for(int j = 0; j < rows; j++)
        {
            sum += stdMarksArr[j][i];
        }
        subjectWiseTotalMarksArr[i] = sum;
        subjectWiseAvgMarksArr[i] = sum / rows;
    }
}

// Function: Display Subject-wise total and Average Marks
void displaySubWiseTotalAndAvgMarks(int columns, float subjectWiseTotalMarksArr[], float subjectWiseAvgMarksArr[])
{
    cout << "\n==============================\n";
    cout << " SUBJECT-WISE TOTAL & AVERAGE\n";
    cout << "==============================\n";

    for(int i = 0; i < columns; i++)
    {
        cout << "Subject " << (i + 1) << ": ";
        cout << "Total = " << setprecision(1) << subjectWiseTotalMarksArr[i]
             << ", Average = " << subjectWiseAvgMarksArr[i] << "\n";
    }
}

// Function: Display highest and lowest marks in the class
void highAndLowMarksInClass(float stdMarksArr[50][50], int rows, int columns)
{
    float highMarks = stdMarksArr[0][0];
    float lowMarks = stdMarksArr[0][0];

    for(int i = 0; i < rows; i++)
    {
        for(int j = 0; j < columns; j++)
        {
            if(highMarks < stdMarksArr[i][j])
            {
                highMarks = stdMarksArr[i][j];
            }
            if(lowMarks > stdMarksArr[i][j])
            {
                lowMarks = stdMarksArr[i][j];
            }
        }
    }

    cout << "\n==============================\n";
    cout << " CLASS HIGH & LOW MARKS\n";
    cout << "==============================\n";
    cout << "Highest mark in class: " << setprecision(1) << highMarks << endl;
    cout << "Lowest  mark in class: " << setprecision(1) << lowMarks << endl;
}
