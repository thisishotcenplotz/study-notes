import time

import uvicorn
from fastapi import FastAPI, Request
from fastapi.staticfiles import StaticFiles
from fastapi.exceptions import RequestValidationError
from fastapi.responses import PlainTextResponse
from fastapi.exceptions import HTTPException
from fastapi.middleware.cors import CORSMiddleware
from tutorial_fastapi import tutorial3, tutorial4, tutorial5, tutorial6, tutorial7, tutorial8

app = FastAPI(
    title='FastAPI Tutorial and Coronavirus Tracker API Docs',
    description='FastAPI Tutorial and Coronavirus Interfaces',
    version='1.0.0',
    docs_url='/oops/yo/docs'
)
app.mount(path='/static', app=StaticFiles(directory='./corona/static'), name='static')


@app.exception_handler(HTTPException)
async def http_exception_handler(request, exc):
    """

    :param request:
    :param exc:
    :return:
    """
    return PlainTextResponse(str(exc), status_code=exc.status_code)


@app.exception_handler(RequestValidationError)
async def validation_exception_handler(request, exe):
    """

    :param request:
    :param exe:
    :return:
    """
    return PlainTextResponse(str(exe), status_code=exe.status_code)


app.middleware('http')


async def add_process_time_header(request: Request, call_next):
    """
    最简单的中间键开发
    拦截所有的请求
    :param request:
    :param call_next:
    :return:
    """
    start = time.time()
    response = await call_next(request)
    duration = time.time() - start
    response.headers['X-Process-Time'] = str(duration)
    return response


"""
跨域资源共享案例
"""

app.add_middleware(
    CORSMiddleware,
    allow_origins=['http://127.0.0.1', 'http://127.0.0.1:8080'],
    allow_credentials=True,
    allow_methods=['*'],
    allow_headers=['*']
)

app.include_router(tutorial3, prefix='/c3', tags=["第三章：请求参数和验证"])
app.include_router(tutorial4, prefix='/c4', tags=["第四章：相应处理和FastAPI配置"])
app.include_router(tutorial5, prefix='/c5', tags=["第五章：FastAPI的依赖注入系统"])
app.include_router(tutorial6, prefix='/c6', tags=["第六章：Oauth2.0的授权模式"])
app.include_router(tutorial7, prefix='/c7', tags=["第七章：请求参数和验证"])
app.include_router(tutorial8, prefix='/c8', tags=["第八章：中间件；跨域资源共享；后台任务；测试用例"])
# app.include_router(corona_app, prefix='/project', tags=["新冠项目"])

if __name__ == '__main__':
    uvicorn.run('run:app', host='0.0.0.0', port=8000, workers=2, reload=True)
