# Generated by Django 5.1.5 on 2025-01-16 13:06

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('app', '0002_create_super_user'),
    ]

    operations = [
        migrations.RemoveField(
            model_name='activity',
            name='file',
        ),
        migrations.RemoveField(
            model_name='process',
            name='file',
        ),
        migrations.RemoveField(
            model_name='task',
            name='file',
        ),
    ]
