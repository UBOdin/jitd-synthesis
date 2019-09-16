#ifndef _TEST_H_SHIELD
#define _TEST_H_SHIELD

#include <istream>

/// Utility functions in driver.cpp

double total_time(timeval &start, timeval &end);

/// Utility Macros for Parsing command strings
/// Typical usage:
///
///   string line;
///   while(getline(input, line)){
///     istringstream toks(line);
///     string op;
///     
///     CASE_1('first_option') {
///       ...
///     } CASE('second_option') {
///       ...
///     } CASE('third_option') {
///       ...
///     } else {
///       /* handle invalid option in 'line' */
///     }
///   }

#define CASE_1(s) toks >> op; if(std::string(s) == op)
#define CASE(s) else if(std::string(s) == op)

#endif // _TEST_H_SHIELD