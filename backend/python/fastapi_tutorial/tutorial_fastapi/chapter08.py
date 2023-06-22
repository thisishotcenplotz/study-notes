from fastapi import APIRouter, BackgroundTasks, Depends
from typing import Optional

tutorial8 = APIRouter()

"""
中间键 【见run.py】
"""

"""
Background Tasks
"""


def bg_task(framework: str):
    for i in range(100):
        print(framework, i)


@tutorial8.post('/background_task')
async def run_bg_tsk(framework: str, background_task: BackgroundTasks):
    """

    :param framework: 被调用的后台任务函数的参数
    :param background_task: FastAPI.BackgroundTasks
    :return:
    """
    background_task.add_task(func=bg_task, framework=framework)
    return {
        'msg': 'The task is running'
    }


def continue_print_str(background_task: BackgroundTasks, q: Optional[str] = None):
    if q:
        background_task.add_task(bg_task, framework=q)
    return q


@tutorial8.post('/dependency/background')
async def dependency_run_bg_task(q: str = Depends(continue_print_str)):
    if q:
        return {
            'msg': 'the task is running'
        }
