#!/usr/bin/env python

girls = ['alice', 'bernice', 'clarice', 'abb']
boys = ['chris', 'arnold', 'bob']

letterGirls = {}

for girl in girls:
    letterGirls.setdefault(girl[0], []).append(girl)
print letterGirls
print [b+'+'+g for b in boys for g in letterGirls[b[0]]]
