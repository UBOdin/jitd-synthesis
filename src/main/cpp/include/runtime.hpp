#ifndef RUNTIME_H_SHIELD
#define RUNTIME_H_SHIELD

#include <vector>

template<class Element>
inline size_t array_size(std::vector<Element> elems) { return elems.size(); }

#endif