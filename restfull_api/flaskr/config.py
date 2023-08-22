import os

from flask import (Flask, abort, flash, g, redirect, render_template, request,
                   session, url_for)

# конфигурация
DATABASE = '/tmp/books_data.db'
DEBUG = True
USERNAME = 'admin'
PASSWORD = 'default'

app = Flask(__name__)
app.config.from_object(__name__)

# Загружаем конфиг по умолчанию и переопределяем в конфигурации часть
# значений через переменную окружения
app.config.update(dict(
    DATABASE=os.path.join(app.root_path, 'books_data.db'),
    DEBUG=True,
    SECRET_KEY='development key',
    USERNAME='admin',
    PASSWORD='default'
))
app.config.from_envvar('FLASKR_SETTINGS', silent=True)
