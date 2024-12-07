from behave import given, when, then
from src.my_queue import MyQueue
from src.my_linked_list import MyLinkedList

@given('I have an empty MyQueue with capacity {capacity:d}')
def step_impl(context, capacity):
    context.queue = MyQueue(capacity)

@when('I enqueue {value:d}')
def step_impl(context, value):
    context.queue.enqueue(value)

@then('the size of the Queue should be {size:d}')
def step_impl(context, size):
    assert context.queue.size() == size

@when('I dequeue')
def step_impl(context):
    context.dequeue_value = context.queue.dequeue()

@then('the first element should be {value:d}')
def step_impl(context, value):
    assert context.dequeue_value == value

@then('I have an empty MyLinkedList')
def step_impl(context):
    context.linked_list = MyLinkedList()

@when('I add {value:d}')
def step_impl(context, value):
    context.linked_list.add(value)

@then('the size of the LinkedList should be {size:d}')
def step_impl(context, size):
    assert context.linked_list.size() == size

@when('I get the element at index {index:d}')
def step_impl(context, index):
    context.value = context.linked_list.get(index)

@then('the value should be {value:d}')
def step_impl(context, value):
    assert context.value == value
