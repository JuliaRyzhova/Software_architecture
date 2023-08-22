from book import Book
from flask import Flask, flash, render_template, request, url_for
from sqlite_book_repository import SQLiteBookRepository
from config import app

app.config['SECRET_KEY'] = '12dhkfsjsle345gsggs6'

menu = [{'name': 'Главная', 'url': '/'},
        {'name': 'Посмотреть все книги', 'url': 'show_books'},
        {'name': 'Добавить новую книгу', 'url': 'add_book'},
        {'name': 'Удалить книгу', 'url': 'delete_book'},
        {'name': 'Изменить данные у книги', 'url': 'update_book'}]


def get_book_repository():
    """Функция создания и инициализации соединения с базой данных"""
    db = SQLiteBookRepository()
    db.create_db()
    return db


@app.route('/', methods=['GET'])
@app.route('/index', methods=['GET'])
def index():
    """Визуализация главной страницы приложения

    Returns:
        render_template: шаблон главной страницы
    """
    print(url_for('index'))
    return render_template('index.html', title='Каталог книг', menu=menu)


@app.route('/add_book', methods=['POST', 'GET'])
def add_book():
    """Визуализация возможности добавления книги в базу данных

    Returns:
        render_template: шаблон добавления новой книги
    """
    print(url_for('add_book'))
    db = get_book_repository()

    if request.method == 'POST':
        print(request.form)
        flash('Новая книга добавлена', category='success')
        book = Book(book_id=None,
                    title=request.form.get('title'),
                    author=request.form.get('author'),
                    price=request.form.get('price'),
                    count_book=request.form.get('count_book'),
                    year_release=request.form.get('year_release'))
        db.add_book(book)
    return render_template('add_book.html', title='Добавить новую книгу', menu=menu)


@app.route('/show_books', methods=['GET'])
def show_books():
    """Показывает все книги

    Returns:
        ender_template: шаблон вывода всех книг из базы данных
    """
    print(url_for('show_books'))
    db = get_book_repository()
    return render_template('book_info.html', books=db.get_all_books(), menu=menu)


@app.route('/delete_book', methods=['POST', 'GET'])
def delete_book():
    """Визуализация возможности удаления книги из базы данных

    Returns:
        render_template: шаблон удаления книги
    """
    print(url_for('show_books'))
    db = get_book_repository()
    if request.method == 'POST':
        print(request.form)
        flash('Книга удалена', category='success')
        db.delete_book(request.form.get('book_id'))

    return render_template('delete_book.html', menu=menu)


@app.route('/update_book', methods=['POST', 'GET'])
def update_book():
    """Визуализация возможности внесения изменений в поля книги

    Returns:
        render_template: шаблон внесения изменений
    """
    print(url_for('update_book'))
    db = get_book_repository()
    if request.method == 'POST':
        print(request.form)
        flash('Данные изменены', category='success')
        result = db.update_book(
            request.form.get('book_id'),
            request.form.get('price'),
            request.form.get('count_book'))

    return render_template('update_book.html', menu=menu)
