# -*- coding: utf-8 -*-
"""
Created on Mon Mar 12 02:00:15 2018

@author: ElSaYeDM
"""

import sqlite3

con=sqlite3.connect('FaceBase.db')
c=con.cursor()
c.execute('create table if not exists People (id int  ,name text )')
c.execute('delete from People ')
con.commit()
con.close()
print('Done')