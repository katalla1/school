
sarcasm->phrase(negative) phrase(positive)
sarcasm->phrase(positive) phrase(negative)
sarcasm->phrase(neutral) phrase(positive)

phrase(positive)-> np(subject) vp(positive)
phrase(neutral)-> np(subject) vp(neutral)
phrase(negative)-> np(subject) vp(negative)
phrase(negative)-> adj(negative) np(_)
phrase(negative)-> adj(negative) np(_) vp(negative)

np(positive)->n(X,positive)
np(positive)->adj(X,positive) n(Y,positive)
np(positive)->adj(X,positive) n(Y, nuetral)

np(neutral)-> n(X,neutral)
np(neutral)-> adj(X,neutral) n(Y,neutral)
np(negative)-> n(X,negative)
np(negative)-> adj(X,negative) n(Y,neutral)
np(negative)-> adj(X,negative) n(Y,negative)

vp(positive)-> v(X,postive)
vp(positive)-> adj(X,positive) v(Y,neutral)
vp(positive)-> adj(X,positive) v(Y,positive)
vp(positive)-> v(X,positive) adj(Y,neutral)
vp(positive)-> v(X,positive) adj(Y,positive)
vp(neutral)-> v(X,neutral)
vp(neutral)-> adj(X,neutral) v(Y,neutral)
vp(negative)-> v(X,negative)
vp(negative)-> adj(X,negative) v(Y,neutral)
vp(negative)-> adj(X,negative) v(Y,negative)
vp(negative)-> v(X,neutral) adj(Y,negative)
vp(negative)-> v(X,negative) adj(Y,negative)
