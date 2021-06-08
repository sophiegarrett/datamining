import sys
#Template for Assignment 1.
#Author: Eric Brigham
##########################
#Date: September 16, 2018
#Note: This implementation is not very efficient. 
# Hint: @lru_cache(maxsize=None) is likely to be a 
#   favourable decoration for some functions.


#Computes the support of the given itemset in the given database.
#itemset: A set of items
#database: A list of sets of items
#return: The number of sets in the database which itemset is a subset of. 
def support(itemset, database):
    count = 0
    for x in database:
        if itemset.issubset(x):
            count+=1
    return count

#Computes the confidence of a given rule.
#The rule takes the form precedent --> antecedent
#precedent: A set of items
#antecedent: A set of items that is a superset of precedent
#database: a list of sets of items.
#return: The confidence in precedent --> antecedent.
###How often is item y occuring when x also occurs
def confidence(precedent, antecedent, database):
    #This can be done simply: support(antecedent)/support(precedent)   
    return support(antecedent, database)/float(support(precedent, database))

#Finds all itemsets in database that have at least minSupport.
#database: A list of sets of items.
#minSupport: an integer > 1
#return: A list of sets of items, such that 
#   s in return --> support(s,database) >= minSupport.
def findFrequentItemsets(database, minSupport):
    FS = []
    cands = []
    for i in database:
        for j in i:
            setj = set([j])
            if setj not in cands:
                cands.append(setj)
    while len(cands) > 0:
        H = []
        for k in cands:
            if support(k, database) >= minSupport:
                if k not in H:
                    H.append(k)
        cands = []
        for h in H:
            for m in H:
                temp1 = h.union(m)
                if h != m and temp1 not in cands:
                    cands.append(temp1)
        if H not in FS:
            if H:
                for x in H:
                    FS.append(x)
    return FS
    
#Given a set of frequently occuring Itemsets, returns
# a list of pairs of the form (precedent, antecedent)
# such that for every returned pair, the rule 
# precedent --> antecedent has confidence >= minConfidence
# in the database.
#frequentItemsets: a set or list of sets of items.
#database: A list of sets of items.
#minConfidence: A real value between 0.0 and 1.0. 
#return: A set or list of pairs of sets of items.
def findRules(frequentItemsets, database, minConfidence):
    Rules = []
    for s in frequentItemsets: 
        for i in frequentItemsets:
            if i != s and s.issubset(i):
                if confidence(s, i, database) >= minConfidence:
                    Rules.append((s, i))
    return Rules 

#Produces a visualization of frequent itemsets.
def visualizeItemsets(frequentItemsets):
    print("---Frequent Itemsets---")
    print(frequentItemsets)

#Produces a visualization of rules.
def visualizeRules(rules):
    print("---Rules---")
    for r in rules:
        print (str(r[0]) + " ===> " + str(r[1]))

def main():
    dataset = []
    with open('../data/data_final.csv') as f:
        lines = f.readlines()
        for line in lines:
            itemset = set([])
            for item in line.split(", "):
                item = item.replace("\n", "")
                itemset.add(item)
            dataset.append(itemset)
    x = findFrequentItemsets(dataset, int(sys.argv[1]))
    visualizeItemsets(x)
    visualizeRules(findRules(x, dataset, float(sys.argv[2])))

if __name__ == "__main__":
    main()
