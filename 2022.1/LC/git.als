module git

one sig Git {
	repositories : set Repository
}

sig Repository {
	mainBranch : one Branch,
	branches : set Branch
}

sig Branch {
	commits : set Commit
}

sig Commit {
	files : some File
}

sig File {}

fact {
	all r : Repository | one repositories.r
	all r1 : Repository, r2 : Repository, b : Branch | (((r1 != r2) and (b in r1.branches or b in r1.mainBranch)) implies (b not in r2.branches and b not in r2.mainBranch)) and (((r1 != r2) and (b in r2.branches or b in r2.mainBranch)) implies (b not in r1.branches and b not in r1.mainBranch))
	all f : File | one files.f
	all c : Commit | one commits.c
}

run example {}
